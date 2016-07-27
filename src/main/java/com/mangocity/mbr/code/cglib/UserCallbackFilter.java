package com.mangocity.mbr.code.cglib;

import java.lang.reflect.Method;
import java.util.Arrays;

import net.sf.cglib.proxy.CallbackFilter;

public class UserCallbackFilter implements CallbackFilter {
	@Override
	public int accept(Method method) {
		if ("findUser".equals(method.getName())) {// 固定值
			return 1;
		} else if (ifMatched(method.getName())) {// 拦截
			return 0;
		} else {
			return 2;
		}
	}

	private boolean ifMatched(String name) {
		if ("addUser".equals(name) || "updateUser".equals(name) || "deleteUser".equals(name)) {
			return true;
		}
		return false;
	}
}
