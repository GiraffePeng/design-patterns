package com.peng.abstarctfactoryinsurance.product;

public class YangguangSurrender implements ISurrender{

	@Override
	public String buildSurrenderContent(String orderNo) {
		return "组装阳光退保报文成功" + orderNo;
	}

}
