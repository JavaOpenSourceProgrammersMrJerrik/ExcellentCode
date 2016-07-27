package com.mangocity.mbr.code.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class UserMethodInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		if ("addUser".equals(method.getName()) || "updateUser".equals(method.getName())
				|| "deleteUser".equals(method.getName())) {
			System.out.println("只有查询权限");
			return null;
		}
		return proxy.invokeSuper(obj, args);
	}

}
