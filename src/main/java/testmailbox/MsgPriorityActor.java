package testmailbox;

import akka.actor.AbstractActor;

public class MsgPriorityActor extends AbstractActor {
    public Receive createReceive() {
        return receiveBuilder().matchAny(System.out::println).build();
    }
}
