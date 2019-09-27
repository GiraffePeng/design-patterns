package com.peng.sms.sdk;

/**
 * 适配者类，(需要被进行适配的类) 
 */
public class SmsSDK {
	
	public Boolean sendSms(String smsKey,String templateId,String content) {
		//这里不探究SDK中封装的方法是如何完成短信发送的，只是模拟
		System.out.println("发送短信成功");
		return true;
	}
}
