package com.mangocity.mbr.code.aop.dynamicproxy;

import com.mangocity.mbr.code.aop.Greeting;


/**
 * 3. JDK 动态代理
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Greeting greeting = new JDKDynamicProxy(new GreetingImpl()).getProxy();
        greeting.sayHello("Jack");
    }
}
