package com.peng.datasoruce.datasource;


public class DataSource {
	
	//模拟单数数据源
	public final static String SINGULAR = "Singular";
	
	//模拟偶数数据源
	public final static String EVENNUMBERS = "EvenNumbers";
	
	//默认数据源为null
	public final static String DEFAULT = null;

	private final static ThreadLocal<String> local = new ThreadLocal<String>();
	
	private DataSource() {};
	
	public static void set(String dataSourceName) {
		local.set(dataSourceName);
	}
	
	public static String get() {
		return local.get();
	}
	
	public static void reset() {
		local.set(DEFAULT);
	}
	
	public static void clear() {
		local.remove();
	}
	
}
