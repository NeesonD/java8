package com.neeson.thread.geek;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author : neeson
 * Date: 2019/7/17
 * Time: 22:57
 * Description: CopyOnWrite
 */
public class RouterTable {

	Map<String, CopyOnWriteArraySet<Router>> rt = new ConcurrentHashMap<>();

	public Set<Router> get(String iface) {
		return rt.get(iface);
	}

	public void remove(Router router) {
		Set set = rt.get(router.getIface());
		if (Objects.nonNull(set)) {
			set.remove(router);
		}
	}

	public void add(Router router) {
		Set<Router> set = rt.computeIfAbsent(router.getIface(), r -> new CopyOnWriteArraySet<>());
		set.add(router);
	}

}
