package com.mangocity.mbr.code.aop.proxychain;

import java.lang.reflect.Method;

public class ErrorProxy extends AbstractProxy {

	@Override
	public void error(Class<?> cls, Method method, Object[] params, Throwable e) {
		System.out.println("自动触发异常处理机制..." + e);
	}

	
}
