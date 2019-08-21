package com.peng.factory;

import com.peng.IPhone;

public class FactoryTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		//创建苹果实例
		IPhoneFactory appleFactory = new ApplePhoneFactory();
		IPhone applePhone = appleFactory.createPhoneByFactory();
		applePhone.createPhone();
		//创建华为实例
		IPhoneFactory huaweiFactory = new HuaweiPhoneFactory();
		IPhone huaweiPhone = huaweiFactory.createPhoneByFactory();
		huaweiPhone.createPhone();
	}
}
