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

	public static void main(String[] args) {
		disruptor.handleEventsWith((event,sequence,endOfBatch) ->{
			System.out.println(event);
			disruptor.start();
			RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
			ByteBuffer byteBuffer = ByteBuffer.allocate(8);
//			for (int i = 0; true ; i++) {
//				byteBuffer.putLong(0, 1);
//				ringBuffer.publishEvent((event,sequence,buffer)->{
//					event.setValue(3);
//				});
//			}

		});
	}

}
