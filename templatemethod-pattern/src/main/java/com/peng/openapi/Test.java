package com.peng.openapi;

import com.alibaba.fastjson.JSONObject;

public class Test {

	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", 1L);
		jsonObject.put("sign", "key");
		jsonObject.put("name", "测试");
		jsonObject.put("phone", "手机号");
		ReceiveService memberReceiveService = new MemberReceiveServiceImpl();
		Result<Object> receiveRequest = memberReceiveService.receiveRequest(jsonObject);
		System.out.println(receiveRequest.getCode()+receiveRequest.getMsg()+receiveRequest.getData());
	}
}
