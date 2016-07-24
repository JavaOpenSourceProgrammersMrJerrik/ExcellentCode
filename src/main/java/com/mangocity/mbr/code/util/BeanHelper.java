package com.mangocity.mbr.code.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// IoC容器
public class BeanHelper {

	// Bean 类 => Bean 实例
	private static final Map<Class<?>, Object> beanMap = new HashMap<Class<?>, Object>();

	/* static {
	        System.out.println("Init BeanHelper...");

	        try {
	            // 获取并遍历所有的 Bean（带有 @Bean 注解的类）
	            List<Class<?>> beanClassList = ClassHelper.getClassListByAnnotation(Bean.class);
	            for (Class<?> beanClass : beanClassList) {
	                // 创建 Bean 实例
	                Object beanInstance;
	                if (BaseService.class.isAssignableFrom(beanClass)) {
	                    // 若为 Service 类，则获取动态代理实例（可以使用 CGLib 动态代理，不能使用 JDK 动态代理，因为初始化 Bean 字段时会报错）
	                    beanInstance = TransactionProxy.getInstance().getProxy(beanClass);
	                } else {
	                    // 否则通过反射创建实例
	                    beanInstance = beanClass.newInstance();
	                }
	                // 将 Bean 实例放入 Bean Map 中（键为 Bean 类，值为 Bean 实例）
	                beanMap.put(beanClass, beanInstance);
	            }

	            // 遍历 Bean Map
	            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
	                ...
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }}*/
}
