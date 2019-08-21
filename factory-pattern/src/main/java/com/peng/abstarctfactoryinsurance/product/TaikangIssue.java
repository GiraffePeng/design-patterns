package com.peng.abstarctfactoryinsurance.product;

public class TaikangIssue implements IIssue{

	@Override
	public String buildIssueContent(String orderNo) {
		return "组装泰康出单报文成功" + orderNo;
	}

}
