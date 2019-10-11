package com.peng.configcenter.java;

import java.util.Properties;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

//具体观察者角色 这里模拟订单服务
@SuppressWarnings("deprecation")
public class OrderService implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("orderService更新属性值");
		Properties properties = (Properties)arg;
		Set<Entry<Object, Object>> entrySet = properties.entrySet();
		for (Entry<Object, Object> entry : entrySet) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}
}
