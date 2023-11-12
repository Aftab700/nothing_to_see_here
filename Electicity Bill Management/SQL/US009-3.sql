-- Create a SQL query to get the ConsumerId and ConsumerName from the Consumers table based on the ConsumerIds of the Bills table who failed to pay the bill
SELECT C.ConsumerId, C.ConsumerName
FROM Consumer C
JOIN MonthlyBill B
ON C.ConsumerId = B.ConsumerId
WHERE B.Status = 'UNPAID';