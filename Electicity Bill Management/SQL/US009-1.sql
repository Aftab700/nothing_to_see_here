-- Create the Consumer table with columns for consumer id, name, address, and phone
CREATE TABLE Consumer (
    ConsumerId INT PRIMARY KEY, -- An integer value for consumer id
    ConsumerName VARCHAR(50) NOT NULL, -- A text value for consumer name
    Address VARCHAR(100) NOT NULL, -- A text value for address
    Phone VARCHAR(10) NOT NULL -- A text value for phone
);

-- Create the MonthlyBill table with columns for bill id, consumer id, amount, and status
CREATE TABLE MonthlyBill (
    BillId INT PRIMARY KEY, -- An integer value for bill id
    ConsumerId INT NOT NULL, -- An integer value for consumer id
    Amount DECIMAL(10, 2) NOT NULL, -- A numeric value for amount
    Status VARCHAR(10) NOT NULL, -- A text value for status (PAID or UNPAID)
    CONSTRAINT FK_ConsumerId FOREIGN KEY (ConsumerId) REFERENCES Consumer(ConsumerId) -- A foreign key constraint to reference the Consumer table
);
