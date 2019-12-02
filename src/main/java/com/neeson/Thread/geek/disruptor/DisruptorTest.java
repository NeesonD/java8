package com.neeson.thread.geek.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.nio.ByteBuffer;

/**
 * @author : neeson
 * Date: 2019/7/21
 * Time: 22:29
 * Description: 
 */
public class DisruptorTest {

	static int bufferSize = 1024;

	static Disruptor<LongEvent> disruptor = new Disruptor(LongEvent::new, bufferSize, DaemonThreadFactory.INSTANCE);

	public static void main(String[] args) throws InterruptedException {
		//注册事件处理器
		disruptor.handleEventsWith(
				(event, sequence, endOfBatch) ->
						System.out.println("E: "+event));

		//启动Disruptor
		disruptor.start();
		//获取RingBuffer
		RingBuffer<LongEvent> ringBuffer
				= disruptor.getRingBuffer();
		//⽣产Event
		ByteBuffer bb = ByteBuffer.allocate(8);
		for (long l = 0; true; l++){
			bb.putLong(0, l);
			//⽣产者⽣产消息
			ringBuffer.publishEvent(
					(event, sequence, buffer) ->
							event.setValue(buffer.getLong(0)), bb);
			Thread.sleep(1000);
		}
	}

}
