/* Write your PL/SQL query statement below */
-- solution 1
SELECT e1.Name AS Employee FROM Employee e1, Employee e2 WHERE e1.ManagerId=e2.Id  AND e1.Salary>e2.Salary;

-- solution 2
SELECT a.name AS Employee FROM Employee a INNER JOIN Employee b ON a.ManagerId = b.id WHERE a.Salary > b.Salary;

-- solution 3
SELECT a.Name AS Employee FROM Employee a WHERE a.Salary > (SELECT b.Salary FROM Employee b WHERE a.ManagerId = b.id);

-- solution 4
SELECT a.name AS Employee FROM Employee a WHERE LEVEL = 2 CONNECT BY nocycle PRIOR a.Salary < a.Salary AND (PRIOR a.id) = a.ManagerId;