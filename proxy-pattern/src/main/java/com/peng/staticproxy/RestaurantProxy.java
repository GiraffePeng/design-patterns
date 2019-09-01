package com.peng.staticproxy;

public class RestaurantProxy implements Restaurant{

	private Restaurant restaurant;

	public RestaurantProxy(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public void foodDelivery() {
		System.out.println("骑手接单");
		restaurant.foodDelivery();
		System.out.println("骑手取餐,送往用户");
	}
}
