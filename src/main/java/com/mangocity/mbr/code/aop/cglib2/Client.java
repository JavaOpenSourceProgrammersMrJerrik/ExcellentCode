package com.mangocity.mbr.code.aop.cglib2;

import java.io.DataInputStream;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;

public class Client {

	public static void main(String[] args) {
		UserDaoImpl userDao = ProxyFactory.getProxy(UserDaoImpl.class, new Callback[] { new UserMethodInterceptor(),
				new UserFixedValue(), NoOp.INSTANCE }, new UserCallbackFilter());
		
		userDao.execute();
	}
}
