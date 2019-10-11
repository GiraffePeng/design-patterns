package com.peng.configcenter.guava;

import java.util.Properties;

import com.google.common.eventbus.EventBus;

public class TestGuava {

	public static void main(String[] args) {
		EventBus eventBus = new EventBus();
		//向配置中心注册信息
		eventBus.register(new OrderService());
		eventBus.register(new UserService());
		//修改配置
	    Properties properties = new Properties();
		properties.put("spring.rabbitmq.host", "127.0.0.1");
		properties.put("spring.rabbitmq.port", "5672");
		//更新配置信息
		eventBus.post(properties);
	}
}
