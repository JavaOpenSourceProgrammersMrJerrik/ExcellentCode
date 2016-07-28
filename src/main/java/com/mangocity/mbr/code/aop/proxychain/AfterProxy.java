package com.mangocity.mbr.code.aop.proxychain;

import java.lang.reflect.Method;

public class AfterProxy extends AbstractProxy {

	@Override
	public void after(Class<?> cls, Method method, Object[] params) throws Exception {
		System.out.println("After");
		throw new Exception("自定义异常");
	}
	
}
