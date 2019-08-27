package com.peng.register;

public class TestContainerSingleton {

	public static void main(String[] args) {
		Object bean = ContainerSingleton.getBean("com.peng.register.TestRegister");
		Object bean1 = ContainerSingleton.getBean("com.peng.register.TestRegister");
		System.out.println(bean);
		System.out.println(bean1);
	}
}
