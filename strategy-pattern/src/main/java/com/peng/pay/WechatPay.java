package com.peng.pay;

public class WechatPay extends PayAbstract{

	@Override
	public String getName() {
		return "微信支付";
	}

	@Override
	protected double queryBalance(String uid) {
		return 900;
	}
}
