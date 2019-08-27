package com.peng.shallow;

import java.util.ArrayList;
import java.util.List;

public class PrototypeTest {

	public static void main(String[] args) {
		ShallowPrototype shallowPrototype = new ShallowPrototype(1, "name", "type",new ArrayList<String>() {{
			add("测试");
		}});
		ShallowPrototype clone = shallowPrototype.clone();
		System.out.println(shallowPrototype.getName() == clone.getName());
		System.out.println(shallowPrototype.getArr() == clone.getArr());
		clone.getArr().add("修改");
		List<String> arr = shallowPrototype.getArr();
		for (String string : arr) {
			System.out.println(string);
		}
	}
}
