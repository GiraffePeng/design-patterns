package com.peng.pay;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PayManager {

	private static Map<String,PayAbstract> payManagers = new ConcurrentHashMap<String, PayAbstract>(); 
	static {
		payManagers.put(PayType.JDPAY.toString(), new JDPay());
		payManagers.put(PayType.ALIPAY.toString(), new AliPay());
		payManagers.put(PayType.WECHANTPAY.toString(), new WechatPay());
	}
	
	private PayManager(){ };
	
	public static void pay(String payType,Order order) {
		PayAbstract payAbstract = payManagers.get(payType);
		System.out.println("欢迎使用" + payAbstract.getName() + "支付");
		PayState pay = payAbstract.pay(order.getUid(), order.getPrice());
		System.out.println("支付结果" + pay.toString());
	}
	
	enum PayType{
		JDPAY,
		ALIPAY,
		WECHANTPAY;
	}
}
