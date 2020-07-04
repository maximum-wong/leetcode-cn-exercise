/* Write your T-SQL query statement below */
-- solution 1
SELECT e1.Name FROM Employee e1, Employee e2 WHERE e1.ManagerId=e2.Id AND e1.Salary>e2.Salary;

-- solution 2
SELECT a.Name AS Employee FROM Employee AS a LEFT JOIN Employee AS b ON a.ManagerId = b.id WHERE a.ManagerId IS NOT NULL AND a.Salary >b.Salary;

-- solution 3
SELECT Name AS Employee FROM Employee a WHERE EXISTS (SELECT 1 FROM Employee b WHERE a.Salary>b.Salary AND b.id=a.ManagerId);