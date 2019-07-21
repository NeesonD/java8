package com.neeson.thread.geek;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author : neeson
 * Date: 2019/7/21
 * Time: 21:40
 * Description: 令牌桶算法
 * 1. 令牌以固定的速率添加到令牌桶中，假设限流的速率是 r/秒，则令牌每 1/r 秒会添加一个；
 * 2. 假设令牌桶的容量是 b ，如果令牌桶已满，则新的令牌会被丢弃；
 * 3. 请求能够通过限流器的前提是令牌桶中有令牌
 */
public class RateLimiterTest {

	static RateLimiter rateLimiter = RateLimiter.create(2.0);
	static ExecutorService es = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		AtomicLong prevTime = new AtomicLong(System.currentTimeMillis());

		for (int i = 0; i < 20; i++) {
			rateLimiter.acquire();
			es.execute(()->{
				long cur = System.currentTimeMillis();
				System.out.println(cur - prevTime.get());
				prevTime.set(cur);
			});
		}

	}

}
