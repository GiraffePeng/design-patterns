package com.peng.datasoruce.entity;

import java.math.BigDecimal;

/**
 * 订单实体类
 */
public class Order {

	//订单主键
	private Integer id;
	
	//订单号
	private String orderSn;
	
	//订单金额
	private BigDecimal price;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Order(Integer id, String orderSn, BigDecimal price) {
		this.id = id;
		this.orderSn = orderSn;
		this.price = price;
	}
}
