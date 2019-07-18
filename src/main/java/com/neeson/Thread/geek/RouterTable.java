package com.neeson.thread.geek;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author : neeson
 * Date: 2019/7/17
 * Time: 22:57
 * Description: CopyOnWrite 和 Balking模式
 */
public class RouterTable {

	Map<String, CopyOnWriteArraySet<Router>> rt = new ConcurrentHashMap<>();

	volatile boolean changed;

	ScheduledExecutorService sec = Executors.newSingleThreadScheduledExecutor();

	public void startLocalSave() {
		sec.scheduleWithFixedDelay(() -> {
			autoSave();
		}, 1, 1, TimeUnit.MINUTES);
	}

	private void autoSave() {
		if (!changed) {
			return;
		}
		changed = false;
		//将路由保存到本地
		this.save2Local();
	}

	private void save2Local() {

	}

	public Set<Router> get(String iface) {
		return rt.get(iface);
	}

	//删除路由
	public void remove(Router router) {
		Set set = rt.get(router.getIface());
		if (Objects.nonNull(set)) {
			set.remove(router);
			//路由表发生变化
			changed = true;
		}
	}

	//增加路由
	public void add(Router router) {
		Set<Router> set = rt.computeIfAbsent(router.getIface(), r -> new CopyOnWriteArraySet<>());
		set.add(router);
		//路由表发生变化
		changed = true;
	}

}
