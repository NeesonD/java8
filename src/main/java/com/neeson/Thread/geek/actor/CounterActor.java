package com.neeson.thread.geek.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : neeson
 * Date: 2019/7/24
 * Time: 12:40
 * Description: 
 */
public class CounterActor extends UntypedActor {

	private int counter = 0;

	@Override
	public void onReceive(Object message) throws Throwable {
		if (message instanceof Number) {
			counter += ((Number) message).intValue();
		} else {
			System.out.println(counter);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ActorSystem actorSystem = ActorSystem.create();
		ExecutorService es = Executors.newFixedThreadPool(4);
		ActorRef counterActor = actorSystem.actorOf(Props.create(CounterActor.class));
		for (int i = 0; i < 4; i++) {
			es.execute(()->{
				for (int j = 0; j < 100000; j++) {
					counterActor.tell(1,ActorRef.noSender());
				}
			});
		}
		es.shutdown();
		Thread.sleep(1000);
		counterActor.tell("", ActorRef.noSender());
		actorSystem.stop(counterActor);
	}

}
