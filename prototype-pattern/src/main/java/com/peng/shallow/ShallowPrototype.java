package com.peng.shallow;

import java.util.List;

public class ShallowPrototype implements PrototypeInteface{

	private int id;
	
	private String name;
	
	private String type;
	
	private List<String> arr;
	

	public List<String> getArr() {
		return arr;
	}

	public void setArr(List<String> arr) {
		this.arr = arr;
	}

	public ShallowPrototype() {
		super();
	}

	public ShallowPrototype(int id, String name, String type,List<String> arr) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.arr = arr;
	}

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
	
	@Override
	public ShallowPrototype clone() {
		ShallowPrototype shallowPrototype = new ShallowPrototype();
		shallowPrototype.setId(this.id);
		shallowPrototype.setName(this.name);
		shallowPrototype.setType(this.type);
		shallowPrototype.setArr(this.arr);
		return shallowPrototype;
	}
}
