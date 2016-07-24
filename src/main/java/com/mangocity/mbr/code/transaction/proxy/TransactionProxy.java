package com.mangocity.mbr.code.transaction.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import com.mangocity.mbr.code.annotation.Transaction;
import com.mangocity.mbr.code.util.DBHelper;

/**
 * 利用CGLIB实现的事务代理
 * 
 * @author YangJie
 *
 */
public class TransactionProxy implements MethodInterceptor {

	private static TransactionProxy instance = new TransactionProxy();

	private TransactionProxy() {
	}

	public static TransactionProxy getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> cls) {
		return (T) Enhancer.create(cls, this);
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		Object result;
		if (method.isAnnotationPresent(Transaction.class)) {// 模拟spring的@Transaction注解
			try {
				// 开启事务
				DBHelper.beginTransaction();

				// 执行操作
				method.setAccessible(true);// 设置访问属性true,可以消除jvm进行安全性检查,可以提升效率。
				result = proxy.invokeSuper(obj, args);

				// 提交事务
				DBHelper.commitTransaction();
			} catch (Exception e) {
				// 回滚事务
				DBHelper.rollbackTransaction();
				e.printStackTrace();
				throw new RuntimeException();
			}
		} else {
			result = proxy.invokeSuper(obj, args);
		}
		return result;
	}

}
