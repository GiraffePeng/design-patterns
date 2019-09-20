package com.peng.bank;

/**
 * 取款业务 
 */
public class BankWithdrawMoney extends BankHandleBusiness{

	@Override
	public boolean checkGrading(String result) {
		System.out.println("该"+result+"进行评分");
		return true;
	}

	@Override
	public String doHandleBusiness(String numberResult) {
		System.out.println(numberResult + "号办理取款业务");
		return "取款业务";
	}

}
