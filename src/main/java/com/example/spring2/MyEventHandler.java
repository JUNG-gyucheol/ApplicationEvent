package com.example.spring2;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.nio.channels.MulticastChannel;

@Component
public class MyEventHandler  {

    /*implements ApplicationListener<Myevent> 스프링 4.2부터는 사용하지안하고
    * 어노테이션 사용 */

    @EventListener //어노테이션 사용 메소드명은 아무거나 지어줘도 됨
//    @Order(Ordered.HIGHEST_PRECEDENCE +2)//똑같은 이벤트핸들러를 실행시키면 순서를 정할 수 있음.
    @Async //비동기방
    public void onApplicationEvent(Myevent myevent) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("이벤트 받았다. 데이터는 " + myevent.getData());
    }
    @EventListener
    @Async
    //초기화 했거나 리프레시 했을 때 발
    public void onApplicationEvent(ContextRefreshedEvent myevent) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextRefreshedEvent ");
    }

    @EventListener
    @Async
    //소멸 되는 시점에서 발생
    public void onApplicationEvent(ContextClosedEvent myevent) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextClosedEvent ");
    }
}
