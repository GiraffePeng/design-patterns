package com.peng.sms.sdk;

import com.peng.sms.api.SmsService;

/**
 * 适配器，将原有的sdk需要传入的smsKey与templateId给自行适配。对外暴露的接口，只传入短信内容即可。
 * 这种方式也符合了迪米特原则，即最少知识原则。
 */
public class SmsSDKServiceImpl implements SmsService{
	
	private SmsSDK smsSDK;
	
	private String smsKey = "2121sjww";
	
	private String templateId = "2j1wiqsw";
	
	public SmsSDKServiceImpl() {
		smsSDK = new SmsSDK();
	}
	
	@Override
	public Boolean sendSms(String content) {
		Boolean sendSms = smsSDK.sendSms(smsKey, templateId, content);
		return sendSms;
	}

}
