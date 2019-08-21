package com.peng.abstarctfactory;

import com.peng.HuaweiPhone;
import com.peng.IPhone;

public class HuaweiFactory implements AbstractFactory{

	@Override
	public IPhone createPhone() {
		return new HuaweiPhone();
	}

	@Override
	public IPc createPc() {
		return new HuaweiPc();
	}

	@Override
	public ITv createTv() {
		return new HuaweiTv();
	}

}
