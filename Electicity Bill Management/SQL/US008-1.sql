-- Create a table named Customer with columns for consumer id, name, address, city, and bill
CREATE TABLE Customer (
    consumer_id INT PRIMARY KEY, -- An integer value for consumer id
    name VARCHAR(50) NOT NULL, -- A text value for name
    address VARCHAR(100) NOT NULL, -- A text value for address
    city VARCHAR(50) NOT NULL, -- A text value for city
    bill DECIMAL(10, 2) NOT NULL -- A numeric value for bill
);
