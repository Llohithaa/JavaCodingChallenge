package com.hexaware.controller;
import java.util.List;
import java.util.Scanner;
import com.hexaware.dao.OrderProcessor;
import com.hexaware.entity.Order;
import com.hexaware.entity.User;
import com.hexaware.exception.OrderNotFoundException;
public class UserController {
	Scanner sc=new Scanner(System.in);
	User user;
	Order order;
	OrderProcessor orderprocessor = new OrderProcessor();
	public void newUser() {
		System.out.println("Enter User Id:");
		int userId=sc.nextInt();
		System.out.println("Enter User Name:");
		String userName=sc.next();
		System.out.println("Enter User password:");
		String password=sc.next();
		String role="User";
		user = new User(userId, userName, password, role);
		orderprocessor.createUser(user);
		System.out.println("User Created Successfully...");
	}
	
	public void newOrder() {
		System.out.println("Enter Order Id:");
		int orderId=sc.nextInt();
		System.out.println("Enter Product Id:");
		int productId=sc.nextInt();
		System.out.println("Enter User Id:");
		int userId=sc.nextInt();
		System.out.println("Enter Quantity:");
		int quantity=sc.nextInt();
		System.out.println("TotalAmount");
		Double totalAmount=sc.nextDouble();
		order=new Order(orderId, productId, userId, quantity, totalAmount);
		orderprocessor.createOrder(order);
	}
	
	public void deleteOrderByOrderId() {
		System.out.println("Enter order Id:");
		int orderId=sc.nextInt();
		try {
	        orderprocessor.cancelOrder(orderId);
	    } catch (OrderNotFoundException e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	public void getOrderWithorderId() {
		System.out.println("Enter UserId:");
		int orderId=sc.nextInt();
		List<Order> orders = orderprocessor.getOrderByUserId(orderId);
        System.out.println("Order Details: ");
        for (Order order : orders) {
            System.out.println(order);
        }
	}


}
