package com.peng.abstarctfactoryinsurance.product;

public interface IIssue {

	//组装出单报文
	public String buildIssueContent(String orderNo); 
}
