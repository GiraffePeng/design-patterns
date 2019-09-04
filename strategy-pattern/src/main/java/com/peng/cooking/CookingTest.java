package com.peng.cooking;

public class CookingTest {

	public static void main(String[] args) {
		Fish fish = new Fish("鲈鱼", 12.2);
		Kitchen.makeFishByTypeName(Kitchen.CookType.BRAISE.toString(), fish);
	}
}
