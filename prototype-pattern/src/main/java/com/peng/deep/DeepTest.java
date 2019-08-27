package com.peng.deep;

import java.util.ArrayList;

public class DeepTest {

	public static void main(String[] args) {
		DeepPrototype deepPrototype = new DeepPrototype();
		deepPrototype.setArr(new ArrayList<String>() {{add("测试");}});
		deepPrototype.setId(1);
		deepPrototype.setName("测试");
		
		
		DeepPrototype cloneObject = (DeepPrototype)deepPrototype.cloneObject();
		
		System.out.println(cloneObject.getArr() == deepPrototype.getArr());
	}
}
