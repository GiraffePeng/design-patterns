package com.peng.staticproxy;

public class TianRestaurant implements Restaurant{

	@Override
	public void foodDelivery() {
		System.out.println("制作美食");
	}

}
