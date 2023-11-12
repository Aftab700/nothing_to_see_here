-- Insert 10 details in the Consumer table
INSERT INTO Consumer (ConsumerId, ConsumerName, Address, Phone) VALUES
(101, 'Alice', '123 Main Street', '9876543210'),
(102, 'Bob', '456 Park Avenue', '8765432109'),
(103, 'Charlie', '789 Pine Road', '7654321098'),
(104, 'David', '101 Maple Lane', '6543210987'),
(105, 'Eve', '234 Elm Street', '5432109876'),
(106, 'Frank', '567 Oak Drive', '4321098765'),
(107, 'Grace', '890 Cherry Court', '3210987654'),
(108, 'Harry', '123 Hill Street', '2109876543'),
(109, 'Irene', '456 Valley Road', '1098765432'),
(110, 'Jack', '789 River Avenue', '0987654321');

-- Insert 10 details in the MonthlyBill table
INSERT INTO MonthlyBill (BillId, ConsumerId, Amount, Status) VALUES
(1, 101, 100.00, 'PAID'),
(2, 102, 150.00, 'UNPAID'),
(3, 103, 200.00, 'PAID'),
(4, 104, 250.00, 'UNPAID'),
(5, 105, 300.00, 'PAID'),
(6, 106, 350.00, 'UNPAID'),
(7, 107, 400.00, 'PAID'),
(8, 108, 450.00, 'UNPAID'),
(9, 109, 500.00, 'PAID'),
(10, 110, 550.00, 'UNPAID');
