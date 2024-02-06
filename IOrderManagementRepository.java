package com.hexaware.dao;

import java.util.List;
import com.hexaware.entity.Order;
import com.hexaware.entity.Product;
import com.hexaware.entity.User;
import com.hexaware.exception.OrderNotFoundException;
import com.hexaware.exception.UserNotFoundException;

public interface IOrderManagementRepository {
	void createOrder(Order order);
	void removeOrder(int userId)throws UserNotFoundException;
	void cancelOrder(int orderId)throws OrderNotFoundException;
	List<Order> getOrderByUserId(int userId);
	List<Order> getOrderByOrderId(int orderId);
	void createUser(User user);
	void createProduct(Product product);
	List<Product> getAllProducts(Product product);
}
