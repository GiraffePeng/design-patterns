package com.peng.register;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

import com.peng.lazysingleton.SingletonLazyInner;

public class TestRegister {

	public static void main(String[] args) throws Exception{
		/*EnumSingleton instance = EnumSingleton.getInstance();
		instance.setData(new Object());
		System.out.println(instance.getData());
		
		FileOutputStream fos = new FileOutputStream("enums.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(instance);
		oos.flush();
		oos.close();
		fos.close();
		//反序列化
		FileInputStream fis = new FileInputStream("enums.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		EnumSingleton singletonLazyInner = (EnumSingleton)ois.readObject();
		System.out.println(singletonLazyInner.getData());
		ois.close();
		fis.close();*/
		EnumSingleton instance = EnumSingleton.getInstance();
		instance.setData(new Object());
		System.out.println(instance.getData());
		
		Class<EnumSingleton> clazz = EnumSingleton.class;
		Constructor constructor =  clazz.getDeclaredConstructor(String.class,int.class);
		constructor.setAccessible(true);
		EnumSingleton enumSingleton = (EnumSingleton)constructor.newInstance("test",2);
		
		System.out.println(enumSingleton.getData());
	}
}
