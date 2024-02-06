create database OrderManagementSystem;
use OrderManagementSystem;

create table Product(
ProductID int auto_increment Primary Key,
ProductName Varchar(20),
Description varchar(50),
Price decimal(7,2),
QuantityInStock int,
Type varchar(15)
)

create table Electronic(
Brand varchar(15),
WarrantyPeriod int,
ProductID int, constraint fk_Electronic
foreign key(ProductID) references Product(ProductID)
)

create table Clothing (
Size varchar(5),
Color varchar(10),
ProductID int, constraint fk_Clothing
foreign key(ProductID) references Product(ProductID)
)

create table User (
UserId int auto_increment primary key,
UserName varchar(20),
Password varchar(15),
Role varchar(10)
)

create table Orders (
OrderID int auto_increment primary key,
ProductID int, constraint fk_Orders
foreign key(ProductID) references Product(ProductID),
UserID int, constraint fk_Orders1
foreign key(UserId) references User(UserId),
Quantity int,
TotalAmount decimal(9,2)
)

Insert into Product(ProductID, ProductName, Description, Price, QuantityInStock, Type)
Values (1, 'Laptop', 'High-performance specs', 49999.00, 10, 'Electronics'),
(2, 'Smartphone', 'Latest model with advanced features', 14999.00, 15, 'Electronics'),
(3, 'T-shirt', 'Comfortable cotton t-shirt', 399.00, 30, 'Clothing'),
(4, 'Jeans', 'Classic denim jeans', 999.00, 25, 'Clothing'),
(5, 'Headphones', 'Wireless bluetooth headphones', 1299.00, 12, 'Electronics');

Insert into Electronic (Brand, WarrantyPeriod, ProductID)
values ('Dell', 1, 1),
('Samsung', 1, 2),
('Sony', 2, 5),
('Apple', 2, 2),
('HP', 1, 1);

Insert into Clothing (Size, Color, ProductID)
values ('M', 'Blue', 4),
('L', 'Black', 4),
('S', 'Red', 3),
('XL', 'Green', 3),
('M', 'White', 3);

Insert into User (UserId, UserName, Password, Role)
values (11, 'admin_user', 'admin_password', 'Admin'),
(12, 'user1', 'user1_password', 'User'),
(13, 'user2', 'user2_password', 'User'),
(14, 'user3', 'user3_password', 'User'),
(15, 'user4', 'user4_password', 'User');

Insert into Orders (OrderID, ProductID, UserID, Quantity, TotalAmount)
values (1, 3, 11, 3, 1197),
(2, 5, 14, 1, 1299),
(3, 2, 13, 2, 29998),
(4, 3, 15, 5, 1995),
(5, 4, 11, 2, 1998);

select * from product;
select * from electronic;
select * from clothing;
select * from user;
select * from orders;