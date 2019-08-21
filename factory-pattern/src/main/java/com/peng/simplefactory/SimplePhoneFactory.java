package com.peng.simplefactory;

import java.util.Calendar;

import com.peng.ApplePhone;
import com.peng.HuaweiPhone;
import com.peng.IPhone;

public class SimplePhoneFactory {
	// 普通工厂模式
	public static IPhone createPhoneFactory(String phoneType) {
		IPhone iphone = null;
		if ("apple".equals(phoneType)) {
			iphone = new ApplePhone();
		} else if ("huawei".equals(phoneType)) {
			iphone = new HuaweiPhone();
		}
		Calendar.getInstance();
		return iphone;
	}

	// 代理实现
	public static IPhone createPhoneFactoryReflex(String className) {
		IPhone iphone = null;
		if (className != null && className != "") {
			try {
				iphone = (IPhone) Class.forName(className).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return iphone;
	}

	// 代理实现
	public static IPhone createPhoneFactoryReflexByClass(Class<? extends IPhone> clazz) {
		IPhone iphone = null;
		if (clazz != null) {
			try {
				iphone = clazz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return iphone;
	}
}
