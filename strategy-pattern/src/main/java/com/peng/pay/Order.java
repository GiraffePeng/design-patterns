package com.peng.pay;

public class Order {

	private String uid;
	
	private String orderSn;
	
	private double price;
	

	public Order(String uid, String orderSn, double price) {
		super();
		this.uid = uid;
		this.orderSn = orderSn;
		this.price = price;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
