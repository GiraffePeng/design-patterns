package com.peng.staticproxy;

public class User {

	public static void main(String[] args) {
		RestaurantProxy restaurantProxy = new RestaurantProxy(new TianRestaurant());
		System.out.println("用户下单");
		restaurantProxy.foodDelivery();
		System.out.println("用户接餐");
	}
}
