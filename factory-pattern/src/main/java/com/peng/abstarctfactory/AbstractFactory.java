package com.peng.abstarctfactory;

import com.peng.IPhone;

public interface AbstractFactory {

	//创建手机
	public IPhone createPhone();
	
	//创建电脑
	public IPc createPc();
	
	//创建电视
	public ITv createTv();
}
