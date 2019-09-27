package com.peng.sms.api;

/**
 * 短信发送接口声明
 */
public interface SmsService {

	/**
	 * 短信发送
	 * @param content 短信的内容
	 * @return 是否发送成功
	 */
	public Boolean sendSms(String content);
}
