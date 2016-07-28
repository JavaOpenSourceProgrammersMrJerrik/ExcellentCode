package com.mangocity.mbr.code.aop.advice;

import org.springframework.aop.framework.ProxyFactory;

import com.mangocity.mbr.code.aop.Greeting;

/**
 * 5. Spring AOP：前置增强 + 后置增强（编程式）【第2版】
 */
public class Client2 {

    public static void main(String[] args) throws Exception {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());

        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("Jack");
    }
}
