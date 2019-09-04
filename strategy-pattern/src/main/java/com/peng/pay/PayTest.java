package com.peng.pay;

public class PayTest {

	public static void main(String[] args) {
		Order order = new  Order("2121", "21322121", 700);
		PayManager.pay(PayManager.PayType.WECHANTPAY.toString(), order);
		
	}
}
