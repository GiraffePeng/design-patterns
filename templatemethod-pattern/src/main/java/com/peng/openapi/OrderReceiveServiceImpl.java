package com.peng.openapi;

import java.math.BigDecimal;

import com.alibaba.fastjson.JSONObject;

/**
 * 下单接口具体实现
 */
public class OrderReceiveServiceImpl extends AbstractReceiveService{

	
	private Order order;
	
	private Result<Object> failResult = new Result<Object>(500, "部分字段缺失,请检查报文信息");
	
	@Override
	public Result<Object> doReceiveOperate() {
		System.out.println("获取到的订单数据为"+order.toString());
		System.out.println("进行订单业务操作流程");
		return new Result<Object>("操作完成");
	}

	@Override
	public Result<Object> checkContent(JSONObject jsonContent) {
		//校验报文是否字段缺失
		Long id = jsonContent.getLong("id");
		String orderSn = jsonContent.getString("orderSn");
		BigDecimal bigDecimal = jsonContent.getBigDecimal("price");
		
		if(id == null || orderSn == null || bigDecimal == null) {
			return failResult;
		}
		//使用建造者模式，对Order进行了改造，内部加入了建造者方法，好处在于不用在一个个的set set set。。。。。
		order = Order.builder().id(id).price(bigDecimal).orderSn(orderSn).build();
		return new Result<Object>("解析成功");
	}

}
