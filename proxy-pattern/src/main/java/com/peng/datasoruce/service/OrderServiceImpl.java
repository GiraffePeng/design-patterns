package com.peng.datasoruce.service;

import com.peng.datasoruce.dao.OrderDao;
import com.peng.datasoruce.entity.Order;

public class OrderServiceImpl implements OrderService{

	private OrderDao orderDao;

	public OrderServiceImpl(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void insertOrder(Order order) {
		orderDao.insertOrder(order);
	}

}
