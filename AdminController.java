package com.hexaware.controller;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.OrderProcessor;
import com.hexaware.entity.Order;
import com.hexaware.entity.Product;
import com.hexaware.exception.UserNotFoundException;
public class AdminController {
	Scanner sc=new Scanner(System.in);
	OrderProcessor orderprocessor = new OrderProcessor();
	Product product;
	public void newProduct() {
		System.out.println("Enter ProductId:");
		int productId=sc.nextInt();
		System.out.println("Enter ProductName:");
		String productName=sc.next();
		System.out.println("Enter Product Description:");
		String description=sc.next();
		System.out.println("Enter Product Price:");
		double price=sc.nextDouble();
		System.out.println("Enter quantityInStock:");
		int quantityInStock=sc.nextInt();
		System.out.println("Enter type:");
		String type=sc.next();
		product=new Product(productId, productName, description, price, quantityInStock, type);
		orderprocessor.createProduct(product);
		System.out.println("Prodcut Added Successfully !!!");
	}
	
	public void getProducts() {
		List<Product> products = orderprocessor.getAllProducts(product);
        System.out.println("Product Details: ");
        for (Product product : products) {
            System.out.println(product);
        }
	}
	
	public void getOrderWithUserId() {
		System.out.println("Enter UserId:");
		int userId=sc.nextInt();
		List<Order> orders = orderprocessor.getOrderByUserId(userId);
        System.out.println("Order Details: ");
        for (Order order : orders) {
            System.out.println(order);
        }
	}
	
	public void deleteOrderByUserId() {
		System.out.println("Enter User Id:");
		int userId=sc.nextInt();
		try {
	        orderprocessor.removeOrder(userId);
	    } catch (UserNotFoundException e) {
	        System.out.println(e.getMessage());
	    }
	}
}
