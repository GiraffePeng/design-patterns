package com.peng.abstarctfactoryinsurance.product;

public class TaikangSurrender implements ISurrender{

	@Override
	public String buildSurrenderContent(String orderNo) {
		return "组装泰康退保报文成功" + orderNo;
	}

}
