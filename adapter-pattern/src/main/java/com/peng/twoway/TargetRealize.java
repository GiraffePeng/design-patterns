package com.peng.twoway;
//目标实现
public class TargetRealize implements TwoWayTarget{

	@Override
	public void request() {
		System.out.println("目标代码被调用！");
	}

}
