package com.mangocity.mbr.code.aop.proxychain;

import java.lang.reflect.Method;

public class BeforeProxy extends AbstractProxy {

	@Override
	public void before(Class<?> cls, Method method, Object[] params) {
		System.out.println("Before");
	}
}
