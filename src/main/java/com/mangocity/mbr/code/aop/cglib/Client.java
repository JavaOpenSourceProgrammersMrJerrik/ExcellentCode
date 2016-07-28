package com.mangocity.mbr.code.aop.cglib;

import com.mangocity.mbr.code.aop.Greeting;

/**
 * 4. CGLib 动态代理
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Greeting greeting = CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
        greeting.sayHello("Jack");
    }
}
