package com.peng.cglibproxy;

import com.peng.staticproxy.Restaurant;
import com.peng.staticproxy.TianRestaurant;

import net.sf.cglib.core.DebuggingClassWriter;

public class TestCglib {
	public static void main(String[] args) {
		//利用 cglib 的代理类可以将内存中的 class 文件写入本地磁盘
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
		"E://cglib_proxy_class/");
		KingHamburgerRestaurant kingHamburgerRestaurant = new KingHamburgerRestaurant();
		CglibProxy cglibProxy = new CglibProxy();
		KingHamburgerRestaurant newInstance = (KingHamburgerRestaurant) cglibProxy.newInstance(kingHamburgerRestaurant);
		newInstance.food();
		
		
	}
}
