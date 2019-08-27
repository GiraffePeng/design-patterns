package com.peng.lazysingleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LazyTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//创建线程
		/*Thread thread = new Thread(new TheradTest());
		
		Thread thread1 = new Thread(new TheradTest());
		
		//开始线程 跑啊跑
		thread.start();
		thread1.start();*/
		
		/*Class<?> clazz = SingletonLazyInner.class;
		try {
			//获取该单例的构造方法
			Constructor c = clazz.getDeclaredConstructor(null);
			//将其私有化的方法进行转为能够访问
			c.setAccessible(true);
			Object object = c.newInstance();
			Object object1 = c.newInstance();
			System.out.println(object);
			System.out.println(object1);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}*/
		
		SingletonLazyInner newInstance = SingletonLazyInner.newInstance();
		try {
			//序列化
			FileOutputStream fos = new FileOutputStream("singleton.obj");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(newInstance);
			oos.flush();
			oos.close();
			fos.close();
			//反序列化
			FileInputStream fis = new FileInputStream("singleton.obj");
			ObjectInputStream ois = new ObjectInputStream(fis);
			SingletonLazyInner singletonLazyInner = (SingletonLazyInner)ois.readObject();
			System.out.println(singletonLazyInner);
			System.out.println(newInstance);
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
