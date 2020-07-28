package com.example.spring2;

import org.springframework.context.ApplicationEvent;

public class Myevent  {
    /*extends ApplicationEvent Spring 4.2이후부터 사용하지않음*/
    private int data;

    private Object source;

    public Myevent(Object source, int data) {
        this.data = data;
        this.source = source;
    }

    public int getData() {
        return data;
    }
}
