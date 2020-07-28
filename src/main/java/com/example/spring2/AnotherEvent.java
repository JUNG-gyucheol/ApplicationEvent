package com.example.spring2;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AnotherEvent {

    @EventListener
//    @Order(Ordered.HIGHEST_PRECEDENCE)//똑같은 이벤트핸들러를 실행시키면 순서를 정할 수 있음.식
    @Async //비동기방식
    public void anotherHandler(Myevent myevent){
        System.out.println(Thread.currentThread().toString());
        System.out.println("anotherHandler : "+ myevent.getData());
    }
    @EventListener
    @Async
    public void onApplicationEvent(ContextClosedEvent myevent) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextClosedEvent ");
    }

}
