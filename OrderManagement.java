package com.hexaware.main;
import java.util.Scanner;

import com.hexaware.controller.AdminController;
import com.hexaware.controller.UserController;
public class OrderManagement {
	public static void main(String[] args)throws Exception {
		Scanner sc=new Scanner(System.in);
		UserController usercontroller=new UserController();
		AdminController admincontroller=new AdminController();
		String fromFirst;
		do {
		System.out.println("-----Welcome to Order Management System-----");
		Thread.sleep(1000);
		System.out.println("Select the the User Type");
		Thread.sleep(1000);
		System.out.println("1.User\n2.Admin");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:{
			System.out.println("1.newUser\n2.newOrder\n3.OrderDetails\n4.deleteOrder");
			int menu=sc.nextInt();
			switch(menu) {
			case 1:usercontroller.newUser();
			break;
			case 2:usercontroller.newOrder();
			break;
			case 3:usercontroller.getOrderWithorderId();
			break;
			case 4:usercontroller.deleteOrderByOrderId();
			break;
			}
			break;
		}
		case 2:{
			System.out.println("1.newOrder\n2.createproduct\n3.deleteOrder\n4.getallproduct");
			int menu=sc.nextInt();
			switch(menu) {
			case 1:usercontroller.newUser();
			break;
			case 2:admincontroller.newProduct();
			break;
			case 3:admincontroller.deleteOrderByUserId();
			break;
			case 4:admincontroller.getProducts();
			}
			
		}
		default:{
			System.out.println("Please enter a valid Input... try again");
		}
		}	
		System.out.println("Do you want to continye? Y/N");
		fromFirst = sc.next();
		}while(fromFirst.equals("Y")|| fromFirst.equals("y"));
	}
}
