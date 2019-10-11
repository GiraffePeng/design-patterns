package com.peng.configcenter.guava;

import java.util.Properties;
import java.util.Map.Entry;

import com.google.common.eventbus.Subscribe;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;

//具体观察者角色 这里模拟用户服务
@SuppressWarnings("deprecation")
public class UserService{

	//基于注解
	@Subscribe
	public void update(Properties properties) {
		System.out.println("userService更新属性值");
		Set<Entry<Object, Object>> entrySet = properties.entrySet();
		for (Entry<Object, Object> entry : entrySet) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}
}
