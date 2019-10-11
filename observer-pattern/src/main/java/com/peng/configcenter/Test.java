package com.peng.configcenter;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		PropertiesSubscription propertiesSubscription = new PropertiesSubscription();
		//向配置中心注册信息
		ServiceInterface userService = new UserService();
		ServiceInterface orderService = new OrderService();
		propertiesSubscription.addService(userService);
		propertiesSubscription.addService(orderService);
		//修改配置
		Properties properties = new Properties();
		properties.put("spring.rabbitmq.host", "127.0.0.1");
		properties.put("spring.rabbitmq.port", "5672");
		//更新配置信息
		propertiesSubscription.updateConfig(properties);
	}
}
