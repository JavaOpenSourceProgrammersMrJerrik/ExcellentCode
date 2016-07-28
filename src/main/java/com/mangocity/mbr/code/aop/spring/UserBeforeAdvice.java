package com.mangocity.mbr.code.aop.spring;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class UserBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("UserBeforeAdvice {}...");
	}

}
