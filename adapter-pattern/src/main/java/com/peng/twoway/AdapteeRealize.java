package com.peng.twoway;

//适配者实现
public class AdapteeRealize implements TwoWayAdapter{

	@Override
	public void specificRequest() {
		System.out.println("适配者代码被调用！");
	}

}
