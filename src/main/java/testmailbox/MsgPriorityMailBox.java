package testmailbox;

import akka.actor.AbstractActor;
import akka.actor.ActorSystem;
import akka.dispatch.Envelope;
import akka.dispatch.PriorityGenerator;
import akka.dispatch.UnboundedStablePriorityMailbox;
import jdk.nashorn.internal.runtime.regexp.joni.Config;

import java.util.Comparator;

public class MsgPriorityMailBox extends UnboundedStablePriorityMailbox {
   public MsgPriorityMailBox(ActorSystem.Settings settings, Config config){
       super(new PriorityGenerator() {
           @Override
           public int gen(Object message) {
               if(message.equals("张三")){
                   return 0;
               }else if( message.equals("李四")){
                   return 1;
               }else if(message.equals("王五")){
                   return 2;
               }else {
                   return 3;
               }
           }
       });

   }
}
