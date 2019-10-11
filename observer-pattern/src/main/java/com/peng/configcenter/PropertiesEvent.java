package com.peng.configcenter;

import java.util.Properties;

//事件类，存储property的所有属性元素，当配置信息发生改变时，该类中的Properties会发生变化。
public class PropertiesEvent {

	private static Properties properties = new Properties();

	private PropertiesEvent() {}

	public static Properties getProperty() {
		return properties;
	}
	
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	public static void clearProperties() {
		properties.clear();
	}

	public static void addProperty(Object key, Object value) {
		if (!properties.containsKey(key)) {
			synchronized (properties) {
				if (!properties.containsKey(key)) {
					properties.put(key, value);
				}
			}
		}
	}

	public void removeProperty(String key) {
		properties.remove(key);
	}
}
