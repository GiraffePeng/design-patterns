package com.peng.pengproxy;

import com.peng.staticproxy.Restaurant;
import com.peng.staticproxy.TianRestaurant;

public class TestP {

	public static void main(String[] args) {
		Restaurant tianRestaurant = new TianRestaurant();
		RiderProxy riderProxy = new RiderProxy();
		
		Restaurant restaurant = (Restaurant) riderProxy.newProxyInstance(tianRestaurant);
		restaurant.foodDelivery();
		
	}
}
