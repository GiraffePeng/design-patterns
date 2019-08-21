package com.peng.abstarctfactoryinsurance.common;


/*
 * 利用HttpClient进行post请求的工具类
 */
public class HttpClientUtil {
	public static String doPost(String url,String xmlContent,String charset){
		System.out.println("请求地址 ：" + url + "请求报文为：" + xmlContent);
		return "返回结果";
	}
}
