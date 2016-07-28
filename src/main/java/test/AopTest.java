package test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mangocity.mbr.code.aop.spring.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AopTest {

	@Resource
	private IUserService userService;
	
	@Autowired
	private ProxyFactoryBean userServiceProxy;

	@Test
	public void testUserService() {
		IUserService us = (IUserService) userServiceProxy.getObject();
		us.addUser();
		
	}
}
