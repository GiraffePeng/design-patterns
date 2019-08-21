package com.peng.abstarctfactoryinsurance.product;

public class YangguangIssue implements IIssue{

	@Override
	public String buildIssueContent(String orderNo) {
		return "组装阳光出单报文完成 "+ orderNo;
	}

}
