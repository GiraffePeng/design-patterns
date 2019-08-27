package com.peng.deep;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class DeepPrototype implements DeepCloneInterface,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
	
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

	public List<String> getArr() {
		return arr;
	}

	public void setArr(List<String> arr) {
		this.arr = arr;
	}

	@Override
	public Object cloneObject() {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			oos.writeObject(this);
		
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			Object readObject = ois.readObject();
			
			ois.close();
			bis.close();
			oos.flush();
			oos.close();
			bos.close();
			return readObject;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
 