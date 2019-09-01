package com.peng.jdkproxy;

import java.io.FileOutputStream;

import com.peng.staticproxy.Restaurant;
import com.peng.staticproxy.TianRestaurant;
//1.7的JDK提供了外部引用
//import sun.misc.ProxyGenerator;

public class TestJdk {

	public static void main(String[] args) {
		Restaurant tianRestaurant = new TianRestaurant();
		RiderProxy riderProxy = new RiderProxy();
		
		Restaurant restaurant = (Restaurant) riderProxy.newProxyInstance(tianRestaurant);
		restaurant.foodDelivery();
		
		//通过反编译工具可以查看源代码
		//byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Restaurant.class});
		//FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
		//os.write(bytes);
		//os.close();
	}
}
