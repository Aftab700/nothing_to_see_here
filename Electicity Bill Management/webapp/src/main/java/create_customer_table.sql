CREATE TABLE Customer (
  ConsumerId VARCHAR(50) NOT NULL PRIMARY KEY,
  bill_number VARCHAR(50) NOT NULL,
  user_title VARCHAR(50) NULL,
  CustomerName VARCHAR(50) NOT NULL,
  Email VARCHAR(255) NOT NULL,
  MobileNumber VARCHAR(15) NOT NULL,
  UserId VARCHAR(20) NOT NULL,
  Password VARCHAR(30) NOT NULL,
  Status VARCHAR(10) NOT NULL DEFAULT 'Active'
);

INSERT INTO Customer (ConsumerId, bill_number, user_title, CustomerName, Email, MobileNumber, UserId, Password) VALUES
(1234567890123, 12345, "Mr.", "Name Test1", "test1@gmail.com", 1234567890, "userid1", "Password@1"),
(2234567890123, 22345, "Mr.", "Name Test2", "test2@gmail.com", 2234567890, "userid2", "Password@2"),
(3234567890123, 32345, "Mr.", "Name Test3", "test3@gmail.com", 3234567890, "userid3", "Password@3"),
(4234567890123, 42345, "Mr.", "Name Test4", "test4@gmail.com", 4234567890, "userid4", "Password@4"),
(5234567890123, 52345, "Mr.", "Name Test5", "test5@gmail.com", 5234567890, "userid5", "Password@5");