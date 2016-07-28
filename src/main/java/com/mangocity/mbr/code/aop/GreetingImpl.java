package com.mangocity.mbr.code.aop;

public class GreetingImpl implements Greeting {
	@Override
	public void sayHello(String name) {
		System.out.println("Hello! " + name);
	}
}
