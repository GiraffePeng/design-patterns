package com.peng.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {
	
	//利用map，将对象进行缓存起来，下次使用时如果map中存在，则从map中获取
	private static Map<String,Object> containerMap = new ConcurrentHashMap<String,Object>();

	private ContainerSingleton() {};
	
	@SuppressWarnings("deprecation")
	public static Object getBean(String className) {
		
		if(!containerMap.containsKey(className)) {
			synchronized (containerMap) {
				if(!containerMap.containsKey(className)) {
					try {
						Object newInstance = Class.forName(className).newInstance();
						containerMap.put(className, newInstance);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return containerMap.get(className);
	}
	
}
