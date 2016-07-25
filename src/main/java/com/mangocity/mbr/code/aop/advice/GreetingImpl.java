package com.mangocity.mbr.code.aop.advice;

import com.mangocity.mbr.code.aop.Greeting;

public class GreetingImpl implements Greeting {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello! " + name);
    }
}
