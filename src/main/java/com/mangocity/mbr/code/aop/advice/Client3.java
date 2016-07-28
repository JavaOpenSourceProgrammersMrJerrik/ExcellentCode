package com.mangocity.mbr.code.aop.advice;

import org.springframework.aop.framework.ProxyFactory;

import com.mangocity.mbr.code.aop.Greeting;

/**
 * 5. Spring AOP：环绕增强（编程式）【第3版】
 */
public class Client3 {

    public static void main(String[] args) throws Exception {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingAroundAdvice());

        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("Jack");
    }
}
