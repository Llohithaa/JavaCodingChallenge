package com.hexaware.entity;

public class Electronic extends Product{
	private String brand;
	private int warrantyPeriod;
	
	//Default constructor
	public Electronic() {
		
	}
	
	//Parameterized Constructor
	public Electronic(String brand, int warrantyPeriod) {
		super();
		this.brand = brand;
		this.warrantyPeriod = warrantyPeriod;
	}
	
	//Getters and Setters
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}
	
	public void setWarrantyPeriod(int warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}
	
	@Override
	public String toString() {
		return "Electronic [brand=" + brand + ", warrantyPeriod=" + warrantyPeriod + "]";
	}	
	
}
