package com.peng.shallow.jdk;

import java.util.List;

//实现Cloneable接口
public class PrototypeClone implements Cloneable{

	private int id;
	
	private String name;
	
	private String type;
	
	private List<String> arr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getArr() {
		return arr;
	}

	public void setArr(List<String> arr) {
		this.arr = arr;
	}

	public PrototypeClone(int id, String name, String type, List<String> arr) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.arr = arr;
	}
	
	public PrototypeClone clone() {
		try {
			//调用super.clone方法
			return (PrototypeClone) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
