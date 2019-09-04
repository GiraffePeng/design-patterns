package com.peng.cooking;

public class CookBraiseService implements CookService{

	@Override
	public void makeFish(Fish fish) {
		System.out.println("红烧"+fish.getWeight()+"斤"+fish.getNameType());
	}
}
