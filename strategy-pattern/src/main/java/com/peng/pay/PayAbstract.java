package com.peng.pay;

public abstract class PayAbstract {

	//获取支付名称
	public abstract String getName();
	
	//查询余额
	protected abstract double queryBalance(String uid);
	
	//扣款支付
	public PayState pay(String uid,double amount) {
		//调用子类的实现方法获取子类中的余额
		if(queryBalance(uid) < amount){
			return new PayState(500,"支付失败","余额不足");
		}
		return new PayState(200,"支付成功","支付金额：" + amount);
	}
}
