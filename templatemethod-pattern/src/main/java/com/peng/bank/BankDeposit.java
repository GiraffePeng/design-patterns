package com.peng.bank;

/**
 * 存款业务
 */
public class BankDeposit extends BankHandleBusiness{

	@Override
	public boolean checkGrading(String result) {
		System.out.println("该"+result+"不进行评分");
		return false;
	}

	@Override
	public String doHandleBusiness(String numberResult) {
		System.out.println(numberResult + "号办理存款业务");
		return "存款业务";
	}

}
