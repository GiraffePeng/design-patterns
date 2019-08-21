package com.peng.factory;

import com.peng.HuaweiPhone;
import com.peng.IPhone;

public class HuaweiPhoneFactory implements IPhoneFactory{

	@Override
	public IPhone createPhoneByFactory() {
		return new HuaweiPhone();
	}
}
