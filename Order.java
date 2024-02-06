package com.hexaware.entity;

public class Order {
	private int orderId;
	private int productId;
	private int userId;
	private int quantity;
	private double totalAmount;
	
	//Default constructor
	public Order() {
		
	}

	//Parameterized Constructor
	public Order(int orderId, int productId, int userId, int quantity, double totalAmount) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}

	//Getters and Setters
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", userId=" + userId + ", quantity="
				+ quantity + ", totalAmount=" + totalAmount + "]";
	}
	
}
