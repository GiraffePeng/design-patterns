package com.peng.abstarctfactoryinsurance.dto;

public class SurrenderDTO {
	
	//订单号 用于退保
	public String orderNo;

	public SurrenderDTO(String orderNo) {
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
