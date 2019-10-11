package com.peng.configcenter;

import java.util.Properties;
import java.util.Map.Entry;
import java.util.Set;

//具体观察者角色 这里模拟订单服务
public class OrderService implements ServiceInterface{

	@Override
	public void refreshConfig(Properties property) {
		System.out.println("orderService更新属性值");
		Set<Entry<Object, Object>> entrySet = property.entrySet();
		for (Entry<Object, Object> entry : entrySet) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}
}
