package com.peng.dispatcher;

public class OrderController {

	@RequestMapping("/getOrderById")
	public void getOrderById(Long oid) {
		System.out.println("根据订单id查询订单信息");
	}
}
