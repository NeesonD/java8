package com.neeson.thread.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.*;

/**
 * @author : neeson
 * Date: 2019/11/30
 * Time: 21:53
 * Description: 
 */
public class DebugTtl {

	private static ExecutorService es = TtlExecutors.getTtlExecutorService(new ThreadPoolExecutor(1, 1,
			0L, TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<Runnable>()));
	private static TransmittableThreadLocal<Integer> transmittableThreadLocal = new TransmittableThreadLocal();
	private static TransmittableThreadLocal<Integer> transmittableThreadLocal2 = new TransmittableThreadLocal();

	public static void main(String[] args) {
		transmittableThreadLocal.set(2);
		es.submit(() -> {
			System.out.println();
		});
		transmittableThreadLocal.set(1);
		es.submit(() -> {
			System.out.println();
		});
	}

	public static void test1() {
		System.out.println();
	}

}
