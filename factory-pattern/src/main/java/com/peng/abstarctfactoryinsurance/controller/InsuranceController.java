package com.peng.abstarctfactoryinsurance.controller;

import com.peng.abstarctfactoryinsurance.common.Result;
import com.peng.abstarctfactoryinsurance.dto.IssueDTO;
import com.peng.abstarctfactoryinsurance.dto.SurrenderDTO;
import com.peng.abstarctfactoryinsurance.factory.InsuranceFactoryService;

//对接保险公司Controller
public class InsuranceController {

	@SuppressWarnings("deprecation")
	public void issue(String factoryName,String orderNo) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		InsuranceFactoryService factoryService = (InsuranceFactoryService) Class.forName(factoryName).newInstance();
		Result issueOrder = factoryService.issueOrder(new IssueDTO(orderNo));
		System.out.println("出单调用结果："+ issueOrder.getData());
	}
	
	
	public void surrender(String factoryName,String orderNo) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		InsuranceFactoryService factoryService = (InsuranceFactoryService) Class.forName(factoryName).newInstance();
		Result surrenderOrder = factoryService.surrenderOrder(new SurrenderDTO(orderNo));
		System.out.println("退保调用结果："+ surrenderOrder.getData());
	}
}
