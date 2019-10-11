package com.peng.configcenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

//具体主题角色 这里模拟配置中心的具体实现
public class PropertiesSubscription {
	
	protected List<ServiceInterface> services = new ArrayList<ServiceInterface>();
	
	public void addService(ServiceInterface serviceInterface) {
		services.add(serviceInterface);
	}
	
	public void removeService(ServiceInterface serviceInterface) {
		services.remove(serviceInterface);
	}
	
	//操作配置中心，对properties属性进行改变
	public void updateConfig(Properties properties) {
		for (Entry<Object, Object> entry : properties.entrySet()) {
			PropertiesEvent.addProperty(entry.getKey(), entry.getValue());
		}
		refreshConfig();
	}
	
	//通知每个服务properties属性发生改变，进行更新
	public void refreshConfig() {
		for(ServiceInterface serviceInterface:services) {
			serviceInterface.refreshConfig(PropertiesEvent.getProperty());
		}
	}
}
