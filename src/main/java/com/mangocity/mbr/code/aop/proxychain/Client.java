package com.mangocity.mbr.code.aop.proxychain;

import java.util.ArrayList;
import java.util.List;

import com.mangocity.mbr.code.aop.advice.GreetingImpl;

public class Client {

	public static void main(String[] args) {
		List<Proxy> proxyList = new ArrayList<Proxy>();
		proxyList.add(new BeforeProxy());
		proxyList.add(new AfterProxy());
		proxyList.add(new ErrorProxy());

		ProxyManager proxyManager = new ProxyManager(GreetingImpl.class, proxyList);
		GreetingImpl greetingProxy = proxyManager.createProxy();
	}
}
