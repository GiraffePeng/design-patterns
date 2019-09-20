package com.peng.openapi;

import com.alibaba.fastjson.JSONObject;

/**
 * 会员接口具体实现
 */
public class MemberReceiveServiceImpl extends AbstractReceiveService{

	private Member member;
	
	private Result<Object> failResult = new Result<Object>(500, "部分字段缺失,请检查报文信息");
	
	@Override
	public Result<Object> doReceiveOperate() {
		System.out.println("获取到的会员数据为"+member.toString());
		System.out.println("进行会员业务操作流程");
		return new Result<Object>("操作完成");
	}

	@Override
	public Result<Object> checkContent(JSONObject jsonContent) {
		//校验报文是否字段缺失
		Long id = jsonContent.getLong("id");
		String name = jsonContent.getString("name");
		String phone = jsonContent.getString("phone");
		
		if(id == null || name == null || phone == null) {
			return failResult;
		}
		//使用建造者模式，对Member进行了改造，内部加入了建造者方法，好处在于不用在一个个的set set set。。。。。
		member = Member.builder().id(id).name(name).phone(phone).build();
		return new Result<Object>("解析成功");
	}

}
