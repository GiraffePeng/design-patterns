package com.peng.cooking;

public class CookSteamedService implements CookService{

	@Override
	public void makeFish(Fish fish) {
		System.out.println("清蒸"+fish.getWeight()+"斤"+fish.getNameType());
	}
}
