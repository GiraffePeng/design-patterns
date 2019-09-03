package com.peng.dispatcher;

public class MemberController {

	@RequestMapping("/getMemberById")
	public void getMemberById(Long mid) {
		System.out.println("根据会员id查询会员信息");
	}
	
}
