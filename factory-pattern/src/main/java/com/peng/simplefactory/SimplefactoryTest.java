package com.peng.simplefactory;

import com.peng.ApplePhone;
import com.peng.IPhone;

public class SimplefactoryTest {
	public static void main(String[] args) {
		//IPhone phone = SimplePhoneFactory.createPhoneFactory("apple");
		//phone.createPhone();
		IPhone phone = SimplePhoneFactory.createPhoneFactoryReflexByClass(ApplePhone.class);
		phone.createPhone();
	}
}
