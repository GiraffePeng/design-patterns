package com.peng.route;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceDelegate{
	
	private static Map<String,IService> serviceMap = new ConcurrentHashMap<String,IService>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		{
			put("member", new MemberService());
			put("order", new OrderService());
		}
	};
	
	/*public static void route(String serviceKey) {
		if(serviceKey.equals("member")) {
			new MemberService().doSomething();
		}else if(serviceKey.equals("order")){
			new OrderService().doSomething();
		}else {
			throw new RuntimeException("404 not found ");
		}
	}*/
	
	public static void route(String serviceKey) {
		IService iService = serviceMap.get(serviceKey);
		if(iService != null) {
			iService.doSomething();
		}else {
			throw new RuntimeException("404 not found ");
		}
	}
}
