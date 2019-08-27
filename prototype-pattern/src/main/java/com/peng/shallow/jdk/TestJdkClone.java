package com.peng.shallow.jdk;

import java.util.ArrayList;

public class TestJdkClone {

	public static void main(String[] args) {
		PrototypeClone prototypeClone = new PrototypeClone(1, "123", "1", new ArrayList<String>() {{add("ceshi");}});
		PrototypeClone clone = prototypeClone.clone();
		System.out.println(prototypeClone.getArr() == clone.getArr());
	}
}
