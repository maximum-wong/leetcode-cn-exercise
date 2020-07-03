# Write your MySQL query statement below
-- solution 1
SELECT
    id,
    SUM(CASE WHEN `month`='Jan' THEN revenue END) AS Jan_Revenue,
    SUM(CASE WHEN `month`='Feb' THEN revenue END) AS Feb_Revenue,
    SUM(CASE WHEN `month`='Mar' THEN revenue END) AS Mar_Revenue,
    SUM(CASE WHEN `month`='Apr' THEN revenue END) AS Apr_Revenue,
    SUM(CASE WHEN `month`='May' THEN revenue END) AS May_Revenue,
    SUM(CASE WHEN `month`='Jun' THEN revenue END) AS Jun_Revenue,
    SUM(CASE WHEN `month`='Jul' THEN revenue END) AS Jul_Revenue,
    SUM(CASE WHEN `month`='Aug' THEN revenue END) AS Aug_Revenue,
    SUM(CASE WHEN `month`='Sep' THEN revenue END) AS Sep_Revenue,
    SUM(CASE WHEN `month`='Oct' THEN revenue END) AS Oct_Revenue,
    SUM(CASE WHEN `month`='Nov' THEN revenue END) AS Nov_Revenue,
    SUM(CASE WHEN `month`='Dec' THEN revenue END) AS Dec_Revenue
FROM Department GROUP BY id;

-- solution 2
SELECT
    id,
    MAX(IF(`month`='Jan', revenue, NULL)) Jan_Revenue,
    MAX(IF(`month`='Feb', revenue, NULL)) Feb_Revenue,
    MAX(IF(`month`='Mar', revenue, NULL)) Mar_Revenue,
    MAX(IF(`month`='Apr', revenue, NULL)) Apr_Revenue,
    MAX(IF(`month`='May', revenue, NULL)) May_Revenue,
    MAX(IF(`month`='Jun', revenue, NULL)) Jun_Revenue,
    MAX(IF(`month`='Jul', revenue, NULL)) Jul_Revenue,
    MAX(IF(`month`='Aug', revenue, NULL)) Aug_Revenue,
    MAX(IF(`month`='Sep', revenue, NULL)) Sep_Revenue,
    MAX(IF(`month`='Oct', revenue, NULL)) Oct_Revenue,
    MAX(IF(`month`='Nov', revenue, NULL)) Nov_Revenue,
    MAX(IF(`month`='Dec', revenue, NULL)) Dec_Revenue
FROM Department GROUP BY id;