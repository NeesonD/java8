package com.neeson.thread.geek.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * @author : neeson
 * Date: 2019/7/24
 * Time: 12:27
 * Description: 
 */
public class HelloActor extends UntypedActor {

	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create();
		ActorRef helloActor = system.actorOf(Props.create(HelloActor.class));
		helloActor.tell("Actor", ActorRef.noSender());
	}

	@Override
	public void onReceive(Object message) throws Throwable {
		System.out.println(message);
	}
}
