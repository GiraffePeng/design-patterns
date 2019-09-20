package com.peng.openapi;

import com.alibaba.fastjson.JSONObject;

/**
 *	我方系统为接收方的接口在此声明
 */
public interface ReceiveService {
	
	final static String SIGN_KEY = "key";

	/**
	 * 声明外部调用我方系统的接口统一入口
	 * @param jsonContent 报文信息
	 * @return
	 */
	public Result<Object> receiveRequest(JSONObject jsonContent);
}
