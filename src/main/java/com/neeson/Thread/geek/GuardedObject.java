package com.neeson.thread.geek;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * @author : neeson
 * Date: 2019/7/17
 * Time: 22:42
 * Description: Guarded Suspension 模式
 */
public class GuardedObject<T> {

	//受保护的对象
	T obj;

	final Lock lock = new ReentrantLock();
	final Condition done = lock.newCondition();
	final int timeout = 1;
	final static Map<Object,GuardedObject> gos = new ConcurrentHashMap<>();

	static <K> GuardedObject create(K key) {
		GuardedObject go = new GuardedObject();
		gos.put(key, go);
		return go;
	}

	static <K, T> void fireEvent(K key, T obj) {
		GuardedObject go = gos.remove(key);
		if (Objects.nonNull(go)) {
			go.onChanged(obj);
		}
	}

	// 获取受保护的对象
	T get(Predicate<T> predicate) {
		lock.lock();
		try {
			//MESA管程推荐写法
			while (!predicate.test(obj)) {
				done.await(timeout, TimeUnit.SECONDS);
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			lock.unlock();
		}
		return obj;
	}

	//事件通知方法
	void onChanged(T obj) {
		lock.lock();
		try {
			this.obj = obj;
			done.signalAll();
		}finally {
			lock.unlock();
		}
	}

}
