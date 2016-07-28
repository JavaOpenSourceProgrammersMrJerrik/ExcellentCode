package com.mangocity.mbr.code.aop.cglib2;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory {
	@SuppressWarnings("unchecked")
	public static <T> T getProxy(Class<T> targetClazz) {
		Enhancer enhancer = createEnhancer(targetClazz);
		return (T) enhancer.create();
	}

	@SuppressWarnings("unchecked")
	public static <T> T getProxy(Class<T> targetClazz, Callback[] callbacks) {
		Enhancer enhancer = createEnhancer(targetClazz);
		enhancer.setCallbacks(callbacks);
		return (T) enhancer.create();
	}

	@SuppressWarnings("unchecked")
	public static <T> T getProxy(Class<T> targetClazz, Callback[] callbacks, CallbackFilter callbackFilter) {
		Enhancer enhancer = createEnhancer(targetClazz);
		enhancer.setCallbacks(callbacks);
		enhancer.setCallbackFilter(callbackFilter);
		return (T) enhancer.create();
	}

	private static <T> Enhancer createEnhancer(Class<T> targetClazz) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(targetClazz);
		return enhancer;
	}
}
