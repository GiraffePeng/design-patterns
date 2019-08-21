package com.peng.abstarctfactoryinsurance.product;

public interface ISurrender {

	//组装退保报文
	public String buildSurrenderContent(String orderNo); 
}
