package com.peng.pay;

public class JDPay extends PayAbstract{

	@Override
	public String getName() {
		return "京东支付";
	}

	@Override
	protected double queryBalance(String uid) {
		return 200;
	}
}
