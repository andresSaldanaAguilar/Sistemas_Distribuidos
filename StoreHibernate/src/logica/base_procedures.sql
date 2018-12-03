-- Database: Store

DROP DATABASE IF EXISTS Store;
CREATE DATABASE Store;
USE Store;

create table customers(
    CustomerID varchar(10) primary key not null,
    CompanyName varchar(40),
    ContactName varchar(30),
    ContactTitle varchar(30),
    Address varchar(60),
    City varchar(15),
    Region varchar(15),
    PostalCode varchar(10),
    Country varchar(15),
    Phone varchar(24),
    Fax varchar(24)
);

create table suppliers(
    SupplierID int primary key not null auto_increment,
    CompanyName varchar(40),
    ContactName varchar(30),
    ContactTitle varchar(30),
    Address varchar(60),
    City varchar(15),
    Region varchar(15),
    PostalCode varchar(10),
    Country varchar(15),
    Phone varchar(24),
    Fax varchar(24),
    HomePage varchar(40)
);

create table categories(
    CategoryID int primary key not null auto_increment,
    CategoryName varchar(15),
    Description longtext,
    Picture varchar(15)
);

create table employees(
    EmployeeID int primary key not null auto_increment,
    Password varchar(20),
    Privilege varchar(1),
    LastName varchar(20),
    FirstName varchar(10),
    Title varchar(30),
    TitleOfCourtesy varchar(25),
    BirthDate varchar(25),
    HireDate varchar(25),
    Address varchar(60),
    City varchar(15),
    Region varchar(15),
    PostalCode varchar(10),
    Country varchar(15),
    HomePhone varchar(24),
    PhoneExtension varchar(4),
    Photo varchar(40), 
    Notes varchar(40),
    ReportsTo varchar(40)
);

create table orders(
    OrderID int primary key not null auto_increment,
    OrderDate varchar(25),
    RequiredDate varchar(25),
    ShippedDate varchar(25),
    ShipVia int,
    Freight decimal,
    ShipName varchar(40),
    ShipAddress varchar(60),
    ShipCity varchar(15),
    ShipRegion varchar(15),
    ShipPostalCode varchar(10),
    ShipCountry varchar(15),
    EmployeeID int,
    CustomerID varchar(10),
        FOREIGN KEY (EmployeeID)
        REFERENCES employees(EmployeeID)
        ON DELETE CASCADE,
        FOREIGN KEY (CustomerID)
        REFERENCES customers(CustomerID)
        ON DELETE CASCADE
);

create table products(
    ProductID int primary key not null auto_increment,
    ProductName varchar(40),
    QuantityPerUnity varchar(20),
    UnitPrice decimal,
    UnitInStock int,
    UnitsOnOrder int,
    ReorderLevel int,
    Discontinued int,
    SupplierID int,
    CategoryID int,
        FOREIGN KEY (SupplierID)
        REFERENCES suppliers(SupplierID)
        ON DELETE CASCADE,
        FOREIGN KEY (CategoryID)
        REFERENCES categories(CategoryID)
        ON DELETE CASCADE
);

create table orderdetails(
    OrderDetailsID int primary key not null auto_increment,
    UnitPrice decimal,
    Quantity int,
    Discount double precision,
    OrderID int,
    ProductID int,
	    FOREIGN KEY (OrderID)
        REFERENCES orders(OrderID)
        ON DELETE CASCADE,
        FOREIGN KEY (ProductID)
        REFERENCES products(ProductID)
        ON DELETE CASCADE
);

delimiter $


create procedure spInsertCustomer(CustomerID varchar(10), CompanyName varchar(40), ContactName varchar(30), ContactTitle varchar(30), Address varchar(60), City varchar(15), Region varchar(25), PostalCode varchar(10), Country varchar(15), Phone varchar(24), Fax varchar(24))
begin
    insert into Customers(CustomerID, CompanyName, ContactName, ContactTitle,Address, City, Region, PostalCode, Country, Phone, Fax) values(CustomerID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax);
end $

create procedure spUpdateCustomer(CustomerID varchar(10), CompanyName varchar(40), ContactName varchar(30), ContactTitle varchar(30), Address varchar(60), City varchar(15), Region varchar(25), PostalCode varchar(10), Country varchar(15), Phone varchar(24), Fax varchar(24))
begin
    update Customers set CompanyName=CompanyName, ContactName=ContactName, ContactTitle=ContactTitle, Address=Address, City=City, Region=Region, PostalCode=PostalCode, Country=Country, Phone=Phone, Fax=Fax where CustomerID=CustomerID;
end $

create procedure spDeleteCustomer(CustomerID varchar(10))
begin 
    delete from Customers where CustomerID = CustomerID;
end $

create procedure spSelectOneCustomer(CustomerIDD varchar(10))
begin
    select * from Customers where CustomerID like CustomerIDD;
end $

create procedure spSelectAllCustomer()
begin
    select * from Customers;
end $


#------------------------------------------------------------------


create procedure spInsertSupplier(CompanyName varchar(40), ContactName varchar(30), ContactTitle varchar(30), Address varchar(60), City varchar(15), Region varchar(25), PostalCode varchar(10), Country varchar(15), Phone varchar(24), Fax varchar(24), HomePage varchar(40))
begin
    insert into suppliers(CompanyName, ContactName, ContactTitle,Address, City, Region, PostalCode, Country, Phone, Fax, HomePage) values(CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax, HomePage);
end $

create procedure spUpdateSupplier(SupplierID int, CompanyName varchar(40), ContactName varchar(30), ContactTitle varchar(30), Address varchar(60), City varchar(15), Region varchar(25), PostalCode varchar(10), Country varchar(15), Phone varchar(24), Fax varchar(24), HomePage varchar(40))
begin
    update suppliers set CompanyName=CompanyName, ContactName=ContactName, ContactTitle=ContactTitle, Address=Address, City=City, Region=Region, PostalCode=PostalCode, Country=Country, Phone=Phone, Fax=Fax where SupplierID=SupplierID;
end $

create procedure spDeleteSupplier(SupplierIDD int)
begin 
    delete from suppliers where SupplierID = SupplierIDD;
end $

create procedure spSelectOneSupplier(SupplierIDD int)
begin
    select * from suppliers where SupplierID like SupplierIDD;
end $

create procedure spSelectAllSupplier()
begin
    select * from suppliers;
end $


#------------------------------------------------------------------


create procedure spInsertCategory(CategoryName varchar(15), Description longtext, Picture varchar(15))
begin
    insert into categories(CategoryName, Description,Picture) values(CategoryName, Description,Picture);
end $

create procedure spUpdateCategory(CategoryID int, CategoryName varchar(15), Description longtext, Picture varchar(15))
begin
    update categories set CategoryName=CategoryName, Description=Description, Picture=Picture where CategoryID=CategoryID;
end $

create procedure spDeleteCategory(CategoryIDD int)
begin 
    delete from categories where CategoryID = CategoryIDD;
end $

create procedure spSelectOneCategory(CategoryIDD int)
begin
    select * from categories where CategoryID like CategoryIDD;
end $

create procedure spSelectAllCategory()
begin
    select * from categories;
end $


#------------------------------------------------------------------


create procedure spInsertEmployee(Password varchar(20),Privilege varchar(1),LastName varchar(20),FirstName varchar(10),Title varchar(30),TitleOfCourtesy varchar(25),BirthDate varchar(25),HireDate varchar(25),Address varchar(60),City varchar(15),Region varchar(15),PostalCode varchar(10),Country varchar(15),HomePhone varchar(24),PhoneExtension varchar(4),Photo varchar(40),Notes varchar(40),ReportsTo varchar(40))
begin
	INSERT INTO employees(Password,Privilege,LastName,FirstName,Title,TitleOfCourtesy,BirthDate,HireDate,Address,City,Region,PostalCode,Country,HomePhone,PhoneExtension,Photo,Notes,ReportsTo)
	               VALUES(Password,Privilege,LastName,FirstName,Title,TitleOfCourtesy,BirthDate,HireDate,Address,City,Region,PostalCode,Country,HomePhone,PhoneExtension,Photo,Notes,ReportsTo);
end $

create procedure spUpdateEmployee(EmployeeID int,Password varchar(20),Privilege varchar(1),LastName varchar(20),FirstName varchar(10),Title varchar(30),TitleOfCourtesy varchar(25),BirthDate varchar(25),HireDate varchar(25),Address varchar(60),City varchar(15),Region varchar(15),PostalCode varchar(10),Country varchar(15),HomePhone varchar(24),PhoneExtension varchar(4),Photo varchar(40),Notes varchar(40),ReportsTo varchar(40))
begin
	UPDATE employees
	SET Password=Password,Privilege=Privilege,LastName = LastName,FirstName = FirstName,Title = Title,TitleOfCourtesy = TitleOfCourtesy,BirthDate = BirthDate,HireDate = HireDate,Address = Address,City = City,Region = Region,PostalCode = PostalCode,Country = Country,HomePhone = HomePhone,PhoneExtension = PhoneExtension,Photo = Photo,Notes = Notes,ReportsTo = ReportsTo WHERE EmployeeID = EmployeeID;
end $

create procedure spDeleteEmployee(EmployeeIDD int)
begin 
    delete from employees where EmployeeID like EmployeeIDD;
end $

create procedure spSelectOneEmployee(EmployeeIDD int)
begin
    select * from employees where EmployeeID like EmployeeIDD;
end $

create procedure spSelectAllEmployee()
begin
    select * from employees;
end $

create procedure spLogInEmployee(BirthDatee varchar(25),FirstNamee varchar(10),LastNamee varchar(20),Passwordd varchar(20))
begin 
    select Privilege from employees where BirthDate like BirthDatee and FirstName like FirstNamee and LastName like LastNamee and Password like Passwordd;
end $



#------------------------------------------------------------------

create procedure spInsertOrder(OrderDate varchar(25),RequiredDate varchar(25),ShippedDate varchar(25),ShipVia int,Freight decimal,ShipName varchar(40),ShipAddress varchar(60),ShipCity varchar(15),ShipRegion varchar(15),ShipPostalCode varchar(10),ShipCountry varchar(15),EmployeeID int,CustomerID varchar(10))
begin
	INSERT INTO orders (OrderDate,RequiredDate,ShippedDate,ShipVia,Freight,ShipName,ShipAddress,ShipCity,ShipRegion,ShipPostalCode,ShipCountry,EmployeeID,CustomerID)
	VALUES(OrderDate,RequiredDate,ShippedDate,ShipVia,Freight,ShipName,ShipAddress,ShipCity,ShipRegion,ShipPostalCode,ShipCountry,EmployeeID,CustomerID);

end $

create procedure spUpdateOrder(OrderIDD int,OrderDate varchar(25),RequiredDate varchar(25),ShippedDate varchar(25),ShipVia int,Freight decimal,ShipName varchar(40),ShipAddress varchar(60),ShipCity varchar(15),ShipRegion varchar(15),ShipPostalCode varchar(10),ShipCountry varchar(15),EmployeeID int,CustomerID varchar(10))
begin
	UPDATE orders 
        SET OrderDate = OrderDate, RequiredDate = RequiredDate, ShippedDate = ShippedDate, ShipVia = ShipVia, Freight = Freight, ShipName = ShipName, ShipAddress = ShipAddress, ShipCity = ShipCity, ShipRegion = ShipRegion, ShipPostalCode = ShipPostalCode, ShipCountry = ShipCountry, EmployeeID = EmployeeID, CustomerID = CustomerID WHERE OrderID = OrderIDD;
end $

create procedure spDeleteOrder(OrderIDD int)
begin 
    delete from orders where OrderID like OrderIDD;
end $

create procedure spSelectOneOrder(OrderIDD int)
begin
    select * from orders where OrderID like OrderIDD;
end $

create procedure spSelectAllOrder()
begin
    select * from orders;
end $


#------------------------------------------------------------------

create procedure spInsertProduct(ProductName varchar(40), QuantityPerUnity varchar(20), UnitPrice decimal, UnitInStock int, UnitsOnOrder int, ReorderLevel int, Discontinued int, SupplierID int, CategoryID int)
begin
	INSERT INTO products (ProductName, QuantityPerUnity, UnitPrice, UnitInStock, UnitsOnOrder, ReorderLevel, Discontinued, SupplierID, CategoryID) 
    VALUES (ProductName, QuantityPerUnity, UnitPrice, UnitInStock, UnitsOnOrder, ReorderLevel, Discontinued, SupplierID, CategoryID);
end $

create procedure spUpdateProduct(ProductID int, ProductName varchar(40), QuantityPerUnity varchar(20), UnitPrice decimal, UnitInStock int, UnitsOnOrder int, ReorderLevel int, Discontinued int, SupplierID int, CategoryID int)
begin
	UPDATE products SET ProductID = ProductID, ProductName = ProductName, QuantityPerUnity = QuantityPerUnity, UnitPrice = UnitPrice, UnitInStock = UnitInStock, UnitsOnOrder = UnitsOnOrder, ReorderLevel = ReorderLevel, Discontinued = Discontinued, SupplierID = SupplierID, CategoryID = CategoryID WHERE ProductID = ProductID;
end $

create procedure spDeleteProduct(ProductIDD int)
begin 
    delete from products where ProductID like ProductIDD;
end $

create procedure spSelectOneProduct(ProductIDD int)
begin
    select * from products where ProductID like ProductIDD;
end $

create procedure spSelectAllProduct()
begin
    select * from products;
end $

#------------------------------------------------------------------

create procedure spInsertOrderdetails(UnitPrice decimal,Quantity int,Discount double precision,OrderID int,ProductID int)
begin
	INSERT INTO orderdetails (UnitPrice, Quantity, Discount, OrderID, ProductID) 
    VALUES (UnitPrice, Quantity, Discount, OrderID, ProductID);
end $

create procedure spUpdateOrderdetails(OrderDetailsID int ,UnitPrice decimal,Quantity int,Discount double precision,OrderID int,ProductID int)
begin
	UPDATE orderdetails SET OrderDetailsID = OrderDetailsID, UnitPrice = UnitPrice, Quantity = Quantity, Discount = Discount,OrderID = OrderID, ProductID = ProductID WHERE OrderDetailsID = OrderDetailsID;
end $

create procedure spDeleteOrderdetails(OrderDetailsIDD int)
begin 
    delete from orderdetails where OrderDetailsID like OrderDetailsIDD;
end $

create procedure spSelectOneOrderdetails(OrderDetailsIDD int)
begin
    select * from orderdetails where OrderDetailsID like OrderDetailsIDD;
end $

create procedure spSelectAllOrderdetails()
begin
    select * from orderdetails;
end $

delimiter ;

call spInsertCustomer('custm1','Microsoft','Stephani','Recruiter','Linden Circle San Franciso','California','East Coast','1803','USA','520980800976','No fax');
call spInsertSupplier('CardBoard Inc.','Aaron','Prime Dealer','Sepulveda Pkwy Los Angeles','California','East Coast','1805','USA','521291011801','No fax','www.itscardboard.com');
call spInsertCategory('Hardware','This are the products  for computers that are tangible','fish.png');
call spInsertEmployee('00011011','0','Last1','First1','Engineer','Sistems Engineer','18-03-1997','12-09-2018','Aviation Av Los Angeles','California','East Coast','1803','USA','520987164265','432','cat.png','Newbie','Danny Mercado');
call spInsertEmployee('00011011','1','Last2','First2','Engineer','Sistems Engineer','18-03-1997','12-09-2018','Aviation Av Los Angeles','California','East Coast','1803','USA','520987164265','432','cat.png','Newbie','Danny Mercado');
call spInsertOrder('10-09-2018','20-09-2018','11-09-2018',1,1,'Andrew','Huntington Beach Los Angeles','California','East Coast','1802','USA',1,'custm1');  
call spInsertProduct('SSD 250GB External','1',100,200,75,3,4,1,1);
call spInsertOrderDetails(100,74,0.34,1,1);


