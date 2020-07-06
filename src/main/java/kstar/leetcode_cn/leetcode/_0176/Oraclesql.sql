/* Write your PL/SQL query statement below */
-- solution 1
SELECT max(Salary) AS SecondHighestSalary FROM(SELECT Salary, dense_rank() over (ORDER BY Salary DESC) r FROM Employee) t WHERE t.r=2

-- solution 2
SELECT max(Salary) AS SecondHighestSalary FROM (SELECT Salary, row_number() over (ORDER BY Salary DESC) AS num FROM employee b GROUP BY Salary) a WHERE a.num = 2

-- solution 3
SELECT  max(salary) AS SecondHighestSalary FROM(SELECT a.salary,rownum AS rn FROM(SELECT DISTINCT salary FROM Employee ORDER BY salary DESC) a) WHERE rn=2