package testmailbox;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.dispatch.CachingConfig;
import com.typesafe.config.ConfigFactory;

public class Main {
    public static void main(String[] args){
        ActorSystem sys = ActorSystem.create("system", ConfigFactory.load("mailbox"));
        ActorRef ref = sys.actorOf(Props.create(MsgPriorityActor.class).withMailbox("prio-dispatcher"),"priorityActor");
        Object [] messages = {"王五","李四", "张三", "小二"};
        for(Object msg:messages){
            ref.tell(msg,ActorRef.noSender());
        }
    }
}
