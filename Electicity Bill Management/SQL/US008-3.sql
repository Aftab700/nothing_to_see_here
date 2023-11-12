-- Calculate the average bill per city and sort them in descending order
SELECT city, AVG (bill) AS average_bill
FROM Customer
GROUP BY city
ORDER BY average_bill DESC;
