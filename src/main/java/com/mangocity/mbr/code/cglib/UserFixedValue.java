package com.mangocity.mbr.code.cglib;

import net.sf.cglib.proxy.FixedValue;

public class UserFixedValue implements FixedValue {

	@Override
	public Object loadObject() throws Exception {
		System.out.println("UserFixedValue 返回固定值...");
		return "*";
	}

}
