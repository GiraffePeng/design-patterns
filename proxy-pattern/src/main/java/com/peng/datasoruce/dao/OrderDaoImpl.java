package com.peng.datasoruce.dao;

import com.peng.datasoruce.datasource.DataSource;
import com.peng.datasoruce.entity.Order;

public class OrderDaoImpl implements OrderDao{

	@Override
	public void insertOrder(Order order) {
		System.out.println("插入订单成功，使用的数据源为"+DataSource.get());
	}

}
