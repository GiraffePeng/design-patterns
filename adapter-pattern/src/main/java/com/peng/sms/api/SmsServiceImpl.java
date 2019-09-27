package com.peng.sms.api;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 */
public class SmsServiceImpl implements SmsService{

	
	private String smsKey = "ssajwi12wwe";
	
	private String templateId = "tejsi1221s";
	
	@Override
	public Boolean sendSms(String content) {
		//处理短信发送逻辑 
		CloseableHttpClient httpclient = HttpClients.createDefault(); 
		HttpPost httpPost = new HttpPost("三方短信平台接口地址");
		// 创建参数队列     
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();   
        formparams.add(new BasicNameValuePair("smsKey", smsKey));   
        formparams.add(new BasicNameValuePair("templateId", templateId)); 
        UrlEncodedFormEntity uefEntity;
        try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httpPost.setEntity(uefEntity); 
			CloseableHttpResponse execute = httpclient.execute(httpPost);
			HttpEntity entity = execute.getEntity();
		} catch (Exception e) {
			e.printStackTrace();
		}   
		System.out.println("短信发送成功");
		return true;
	}

}
