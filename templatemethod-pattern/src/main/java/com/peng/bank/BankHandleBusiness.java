package com.peng.bank;

import java.util.UUID;

/**
 * 抽象类
 * 银行办理业务
 */
public abstract class BankHandleBusiness {

	//模板方法
	public void handleBusiness() {
		//1、取号
		String numberResult = offerNumber();
		//2、排队
		waitLine(numberResult);
		//3、办理业务
		String result = doHandleBusiness(numberResult);
		//是否需要给业务员评分，属于钩子方法
		if(checkGrading(result)) {
			//4、给业务员评分
			standardsGrading(result);
		}
		
	}

	//具体方法
	private void standardsGrading(String result) {
		System.out.println(result+"成功,评分3分");
	}
	
	//具体方法
	private void waitLine(String numberResult) {
		System.out.println("等待被叫号......");
		System.out.println("号码"+numberResult+"请到窗口办理业务");
	}

	//具体方法
	private String offerNumber() {
		String number = UUID.randomUUID().toString().substring(0,5);
		System.out.println("取号的号码为" + number);
		return number;
	}
	
	//钩子方法
	public abstract boolean checkGrading(String result);
	
	//抽象方法
	public abstract String doHandleBusiness(String numberResult);
}
