# Write your MySQL query statement below
-- solution 1
SELECT e1.Name AS Employee FROM Employee e1, Employee e2 WHERE e1.ManagerId=e2.Id  AND e1.Salary>e2.Salary;

-- solution 2
SELECT a.name AS Employee FROM Employee AS a LEFT JOIN Employee AS b ON a.managerid = b.id  WHERE a.managerid IS NOT NULL AND a.salary > b.salary;

-- solution 2
SELECT Name AS `Employee` from Employee a WHERE EXISTS (SELECT 1 FROM Employee b WHERE a.Salary>b.Salary AND b.id=a.ManagerId);