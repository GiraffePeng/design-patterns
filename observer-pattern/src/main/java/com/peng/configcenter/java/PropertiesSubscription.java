package com.peng.configcenter.java;

import java.util.Observable;
import java.util.Properties;


//具体主题角色 这里模拟配置中心的具体实现
public class PropertiesSubscription extends Observable {

	// 操作配置中心，对properties属性进行改变
	public void updateConfig(Properties properties) {
		super.setChanged();
		super.notifyObservers(properties);
	}
}
