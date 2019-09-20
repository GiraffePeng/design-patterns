package com.peng.openapi;

import java.io.Serializable;
import java.math.BigDecimal;

public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String orderSn;
	
	private BigDecimal price;
	

	public Order(Long id, String orderSn, BigDecimal price) {
		super();
		this.id = id;
		this.orderSn = orderSn;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public String getOrderSn() {
		return orderSn;
	}

	public BigDecimal getPrice() {
		return price;
	}

	
	//这里使用建造者模式，将该bean进行处理，可以更方便的赋值
	static class OrderBuilder{
		
		private Long id;
		
		private String orderSn;
		
		private BigDecimal price;
		
		public OrderBuilder id(Long id) {
			this.id = id;
			return this;
		}
		
		public OrderBuilder orderSn(String orderSn) {
			this.orderSn = orderSn;
			return this;
		}
		
		public OrderBuilder price(BigDecimal price) {
			this.price = price;
			return this;
		}
		
		public Order build() {
			return new Order(id, orderSn, price);
		}
	}
	
	public static OrderBuilder builder(){
		return new OrderBuilder();
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderSn=" + orderSn + ", price=" + price + "]";
	}
}
