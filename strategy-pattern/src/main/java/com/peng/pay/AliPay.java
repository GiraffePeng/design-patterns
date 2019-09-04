package com.peng.pay;

public class AliPay extends PayAbstract{

	@Override
	public String getName() {
		return "支付宝支付";
	}

	@Override
	protected double queryBalance(String uid) {
		return 500;
	}
}
