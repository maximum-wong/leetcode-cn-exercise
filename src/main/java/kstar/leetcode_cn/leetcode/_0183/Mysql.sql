# Write your MySQL query statement below
-- solution 1
SELECT c.Name AS Customers FROM Customers c LEFT JOIN Orders o ON c.Id=o.CustomerId WHERE o.CustomerId IS NULL;

-- solution 2
SELECT c.name AS Customers FROM Customers c WHERE c.id NOT IN (SELECT CustomerId FROM Orders);

-- solution 3
SELECT NAME AS Customers FROM Customers a WHERE NOT EXISTS (SELECT Id, CustomerId FROM Orders b WHERE a.id=b.CustomerId);