package com.peng.abstarctfactoryinsurance.test;

import com.peng.abstarctfactoryinsurance.controller.InsuranceController;

public class InsuranceTest {
	
	public static void main(String[] args) {
		//调用泰康出单
		InsuranceController insuranceController = new InsuranceController();
		try {
			insuranceController.issue("com.peng.abstarctfactoryinsurance.factory.TaiKangFactoryService", "20190812212121");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
