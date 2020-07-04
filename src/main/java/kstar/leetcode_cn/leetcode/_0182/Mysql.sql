# Write your MySQL query statement below
-- solution 1
SELECT Email FROM Person GROUP BY Email HAVING COUNT(Email) > 1;

-- solution 2
SELECT Email FROM (SELECT Email, COUNT(Email) AS num FROM Person GROUP BY Email) tmp WHERE num>1;

-- solution 3
SELECT DISTINCT a.email AS Email FROM person a INNER JOIN person b ON (a.email = b.email AND a.id <> b.id);