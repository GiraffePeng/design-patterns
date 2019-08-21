package com.peng.abstarctfactory;

import com.peng.IPhone;

public class AbstarctFactoryTest {

	public static void main(String[] args) {
		//调用华为工厂
		AbstractFactory abstractFactory = new HuaweiFactory();
		IPhone huaweiPhone = abstractFactory.createPhone();
		IPc huaweiPhonePc = abstractFactory.createPc();
		ITv huaweiPhoneTv = abstractFactory.createTv();
		
		
		//调用苹果工厂
		AbstractFactory appleFactory = new AppleFactory();
		IPhone applePhone = appleFactory.createPhone();
		IPc applePc = appleFactory.createPc();
		ITv appleTv = appleFactory.createTv();
	}
}
