package com.peng.datasoruce.dao;

import javax.xml.crypto.Data;

import com.peng.datasoruce.datasource.DataSource;
import com.peng.datasoruce.entity.Order;

public class OrderDaoProxy implements OrderDao{
	
	private OrderDao orderDao;
	
	public OrderDaoProxy(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void insertOrder(Order order) {
		//订单的主键为偶数，则使用偶数数据源
		if(order.getId() % 2 == 0) {
			DataSource.set(DataSource.EVENNUMBERS);
		}else{
			//为奇数，使用奇数数据源
			DataSource.set(DataSource.SINGULAR);
		}
		orderDao.insertOrder(order);
		//重置数据源
		DataSource.reset();
	}

}
