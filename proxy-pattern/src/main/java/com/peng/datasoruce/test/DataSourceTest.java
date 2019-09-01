package com.peng.datasoruce.test;


import java.math.BigDecimal;

import com.peng.datasoruce.dao.OrderDao;
import com.peng.datasoruce.dao.OrderDaoImpl;
import com.peng.datasoruce.dao.OrderDaoJdkProxy;
import com.peng.datasoruce.entity.Order;
import com.peng.datasoruce.service.OrderService;
import com.peng.datasoruce.service.OrderServiceImpl;

public class DataSourceTest {

	public static void main(String[] args) {
		//OrderService orderServiceImpl = new OrderServiceImpl(new OrderDaoProxy(new OrderDaoImpl()));
		//orderServiceImpl.insertOrder(new Order(1, "123", new BigDecimal("21.21")));
	
		OrderDaoJdkProxy orderDaoJdkProxy = new OrderDaoJdkProxy();
		OrderDao orderDao = (OrderDao) orderDaoJdkProxy.newProxyInstance(new OrderDaoImpl());
		
		OrderService orderServiceImpl = new OrderServiceImpl(orderDao);
		
		orderServiceImpl.insertOrder(new Order(1, "123", new BigDecimal("21.21")));
	}
}
