package com.hexaware.entity;

public class Clothing extends Product{
	private String size;
	private String color;
	
	//Default constructor
	public Clothing() {
			
	}

	//Parameterized Constructor
	public Clothing(String size, String color) {
		super();
		this.size = size;
		this.color = color;
	}

	//Getters and Setters
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Clothing [size=" + size + ", color=" + color + "]";
	}
		
}
