# Write your MySQL query statement below
-- solution 1
SELECT class FROM courses GROUP BY class HAVING COUNT(DISTINCT student)>=5;

-- solution 2
SELECT class FROM (SELECT class, COUNT(DISTINCT student) AS stu_num FROM courses GROUP BY class) AS tmp_table WHERE stu_num>=5;