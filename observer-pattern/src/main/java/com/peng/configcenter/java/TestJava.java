package com.peng.configcenter.java;

import java.util.Properties;

public class TestJava {

	public static void main(String[] args) {
		//向配置中心注册信息
		PropertiesSubscription propertiesSubscription = new PropertiesSubscription();
		propertiesSubscription.addObserver(new OrderService());
		propertiesSubscription.addObserver(new UserService());
		
		//修改配置
	    Properties properties = new Properties();
		properties.put("spring.rabbitmq.host", "127.0.0.1");
		properties.put("spring.rabbitmq.port", "5672");
		//更新配置信息
		propertiesSubscription.updateConfig(properties);
	}
}
