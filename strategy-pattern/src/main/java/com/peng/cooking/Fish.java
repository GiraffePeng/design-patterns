package com.peng.cooking;

import java.io.Serializable;

public class Fish implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8617430338527775356L;

	//鱼的种族名称
	private String nameType;
	
	//鱼的重量(斤)
	private double weight;

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Fish(String nameType, double weight) {
		this.nameType = nameType;
		this.weight = weight;
	}

	public Fish() {
	}
}
