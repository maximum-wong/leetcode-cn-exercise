/* Write your T-SQL query statement below */
-- solution 1
SELECT ISNULL((SELECT TOP 1 Salary FROM Employee WHERE Salary NOT IN  (SELECT MAX(Salary) FROM Employee) ORDER BY Salary DESC), NULL) AS SecondHighestSalary;

-- solution 2
SELECT max(Salary) AS SecondHighestSalary FROM(SELECT Salary, dense_rank() over (ORDER BY Salary DESC) r FROM Employee) t WHERE t.r=2;

-- solution 3
SELECT max(Salary) AS SecondHighestSalary FROM (SELECT Salary, row_number() over (ORDER BY Salary DESC) AS num FROM employee b GROUP BY Salary) a WHERE a.num = 2;