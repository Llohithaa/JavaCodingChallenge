package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.Order;
import com.hexaware.entity.Product;
import com.hexaware.entity.User;
import com.hexaware.exception.OrderNotFoundException;
import com.hexaware.exception.UserNotFoundException;
import com.hexaware.util.DBConnUtil;

public class OrderProcessor implements IOrderManagementRepository{
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	Product product;
	User user;
	Order order;
	
	public void createOrder(Order order) {
		try {
			con = DBConnUtil.getDBConn();
			ps = con.prepareStatement("insert into orders values(?,?,?,?,?)");
			ps.setInt(1, order.getOrderId());
			ps.setInt(2, order.getProductId());
			ps.setInt(3, order.getUserId());
			ps.setInt(4, order.getQuantity());
			ps.setDouble(5, order.getTotalAmount());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + "rows inserted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
    }
	
	public void removeOrder(int userId) throws UserNotFoundException {
		try {
			con = DBConnUtil.getDBConn();
			ps = con.prepareStatement("delete from orders where userId=?");
			ps.setInt(1, userId);
			int noofrows = ps.executeUpdate();
			if (noofrows == 0) {
	            throw new UserNotFoundException("User with ID " + userId + " not found.");
	        }
			System.out.println(noofrows + " removed Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void cancelOrder(int orderId) throws OrderNotFoundException {
		try {
			con = DBConnUtil.getDBConn();
			ps = con.prepareStatement("delete from orders where orderId=?");
			ps.setInt(1, orderId);
			int noofrows = ps.executeUpdate();
			if (noofrows == 0) {
	            throw new OrderNotFoundException("Order with ID " + orderId + " not found.");
	        }
			System.out.println(noofrows + " removed Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
public List<Order> getOrderByOrderId(int orderId) {
		
		List<Order> OrdersList=new ArrayList<>();
		try {
			con = DBConnUtil.getDBConn();
			ps=con.prepareStatement("select * from orders where orderId=?");
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			while (rs.next()) {
				orderId = rs.getInt("orderId");
				int productId = rs.getInt("productId");
				int userId = rs.getInt("userId");
				int quantity=rs.getInt("quantity");
				double totalAmount = rs.getDouble("totalAmount");
                order = new Order(orderId, productId, userId, quantity, totalAmount);
                OrdersList.add(order);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return OrdersList;
	}
	
	
	public List<Order> getOrderByUserId(int userId) {
		
		List<Order> OrdersList=new ArrayList<>();
		try {
			con = DBConnUtil.getDBConn();
			ps=con.prepareStatement("select * from orders where userId=?");
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				int orderId = rs.getInt("orderId");
				int productId = rs.getInt("productId");
				userId = rs.getInt("userId");
				int quantity=rs.getInt("quantity");
				double totalAmount = rs.getDouble("totalAmount");
                order = new Order(orderId, productId, userId, quantity, totalAmount);
                OrdersList.add(order);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return OrdersList;
	}
	
	public void createUser(User user) {
		try {
			con = DBConnUtil.getDBConn();
			ps = con.prepareStatement("insert into user values(?,?,?,?)");
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getRole());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
    }
	
	public void createProduct(Product product) {
		try {
			con = DBConnUtil.getDBConn();
			ps = con.prepareStatement("insert into product values(?,?,?,?,?,?)");
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getDescription());
			ps.setDouble(4, product.getPrice());
			ps.setInt(5, product.getQuantityInStock());
			ps.setString(6, product.getType());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
    }
	
	public List<Product> getAllProducts(Product product){
		List<Product> productDetailList=new ArrayList<>();
		try {
			con = DBConnUtil.getDBConn();
			ps=con.prepareStatement("select * from product");
			rs = ps.executeQuery();
			while(rs.next()) {
				int productId = rs.getInt("productId");
				String productName = rs.getString("productName");
				String description = rs.getString("description");
                double price = rs.getDouble("price");
                int quantityInStock = rs.getInt("quantityInStock");
                String type = rs.getString("type");
                product = new Product(productId, productName, description, price, quantityInStock, type);
                productDetailList.add(product);

			}
				
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return productDetailList;
	}

}
