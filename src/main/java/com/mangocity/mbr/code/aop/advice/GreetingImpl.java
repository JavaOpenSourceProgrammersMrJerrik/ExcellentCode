package com.mangocity.mbr.code.aop.advice;

import com.mangocity.mbr.code.aop.Greeting;

public class GreetingImpl implements Greeting {

    public void sayHello(String name) throws Exception {
        System.out.println("Hello! " + name);
        throw new Exception("222");
    }
}
