package com.peng.abstarctfactoryinsurance.dto;

public class IssueDTO {
	
	//订单号 用于出单
	public String orderNo;

	public IssueDTO(String orderNo) {
		super();
		this.orderNo = orderNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
}
