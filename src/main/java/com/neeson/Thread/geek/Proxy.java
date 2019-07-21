package com.neeson.thread.geek;

/**
 * @author : neeson
 * Date: 2019/7/19
 * Time: 20:46
 * Description: 两阶段终止，一阶段通过 interrupt() 发送指令，二阶段通过 isInterrupted() 来查看标志位响应中断
 * 一个是仅检查终止标志位是不够的，因为线程的状态可能处于休眠态；另一个是仅检
 * 查线程的中断状态也是不够的，因为我们依赖的第三方类库很可能没有正确处理中断异常
 */
public class Proxy {

	volatile boolean started = false;

	Thread rptThread;

	synchronized void start() {
		if (started) {
			return;
		}
		started = true;
		rptThread = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				//采集数据
				report();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// 因为异常会清掉线程中断的状态，所以这里需要恢复中断状态
					Thread.currentThread().interrupt();
				}
			}
			started = false;
		});
		rptThread.start();
	}

	synchronized void stop() {
		rptThread.interrupt();
	}

	private void report() {

	}

}
