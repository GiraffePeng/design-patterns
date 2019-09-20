package com.peng.bank;

public class BankMain {

	public static void main(String[] args) {
		//调用存款业务
		BankHandleBusiness bankDeposit = new BankDeposit();
		bankDeposit.handleBusiness();
		
		System.out.println("----------------------------");
		
		//调用取款业务
		BankHandleBusiness bankWithdrawMoney = new BankWithdrawMoney();
		bankWithdrawMoney.handleBusiness();
	}
}
