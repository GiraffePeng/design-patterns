package com.peng.cooking;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Kitchen {

	
	private static Map<String,CookService> cookMap = new ConcurrentHashMap<String,CookService>();
	
	static {
		cookMap.put(CookType.BRAISE.toString(), new CookBraiseService());
		cookMap.put(CookType.STEAMED.toString(), new CookSteamedService());
	}
	
	private Kitchen() {
		
	}

	public static void makeFishByTypeName(String type,Fish fish) {
		CookService cookService = cookMap.get(type);
		if(cookService == null) {
			notFoundException();
		}
		cookService.makeFish(fish);
	}
	
	private static void notFoundException() {
		throw new RuntimeException("not found type");
	}
	
	enum CookType {
		BRAISE,
		STEAMED;
	}
}
