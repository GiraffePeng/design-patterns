package com.peng.abstarctfactory;

import com.peng.ApplePhone;
import com.peng.IPhone;

public class AppleFactory implements AbstractFactory{

	@Override
	public IPhone createPhone() {
		return new ApplePhone();
	}

	@Override
	public IPc createPc() {
		return new ApplePc();
	}

	@Override
	public ITv createTv() {
		return new AppleTv();
	}

}
