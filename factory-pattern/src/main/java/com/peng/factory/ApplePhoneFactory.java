package com.peng.factory;

import com.peng.ApplePhone;
import com.peng.IPhone;

public class ApplePhoneFactory implements IPhoneFactory{

	@Override
	public IPhone createPhoneByFactory() {
		return new ApplePhone();
	}
}
