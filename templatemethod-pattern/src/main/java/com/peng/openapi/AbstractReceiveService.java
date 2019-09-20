package com.peng.openapi;

import com.alibaba.fastjson.JSONObject;

public abstract class AbstractReceiveService implements ReceiveService{

	@Override
	public Result<Object> receiveRequest(JSONObject jsonContent){
		//1、校验签名是否正确
		Result<Object> checkSign = checkSign(jsonContent);
		if(checkSign.getCode() != 200) {
			return checkSign;
		}
		//2、校验报文格式是否正确，如果正确并进行解析。 该操作交给具体的子类来实现
		Result<Object> checkContent = checkContent(jsonContent);
		if(checkContent.getCode() != 200) {
			return checkContent;
		}
		//3、根据解析的报文数据进行DB操作。该操作交给具体的子类来实现
		return doReceiveOperate();
	}
	
	//判断请求的报文是否验签通过
	public Result<Object> checkSign(JSONObject dataContent){
		String sign = dataContent.getString("sign");
		if(sign == null || !SIGN_KEY.equals(sign)) {
			return new Result<Object>(500,"验签错误");
		}
		return new Result<Object>(true);
	}

	public abstract Result<Object> doReceiveOperate();

	public abstract Result<Object> checkContent(JSONObject jsonContent);

}
