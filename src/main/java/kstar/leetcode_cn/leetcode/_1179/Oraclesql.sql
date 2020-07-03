/* Write your PL/SQL query statement below */
-- solution 1
SELECT
    id,
    SUM(CASE WHEN month='Jan' THEN revenue END) AS Jan_Revenue,
    SUM(CASE WHEN month='Feb' THEN revenue END) AS Feb_Revenue,
    SUM(CASE WHEN month='Mar' THEN revenue END) AS Mar_Revenue,
    SUM(CASE WHEN month='Apr' THEN revenue END) AS Apr_Revenue,
    SUM(CASE WHEN month='May' THEN revenue END) AS May_Revenue,
    SUM(CASE WHEN month='Jun' THEN revenue END) AS Jun_Revenue,
    SUM(CASE WHEN month='Jul' THEN revenue END) AS Jul_Revenue,
    SUM(CASE WHEN month='Aug' THEN revenue END) AS Aug_Revenue,
    SUM(CASE WHEN month='Sep' THEN revenue END) AS Sep_Revenue,
    SUM(CASE WHEN month='Oct' THEN revenue END) AS Oct_Revenue,
    SUM(CASE WHEN month='Nov' THEN revenue END) AS Nov_Revenue,
    SUM(CASE WHEN month='Dec' THEN revenue END) AS Dec_Revenue
FROM Department GROUP BY id;

-- solution 2
SELECT
    id,
    MAX(CASE WHEN month='Jan' THEN revenue END) AS Jan_Revenue,
    MAX(CASE WHEN month='Feb' THEN revenue END) AS Feb_Revenue,
    MAX(CASE WHEN month='Mar' THEN revenue END) AS Mar_Revenue,
    MAX(CASE WHEN month='Apr' THEN revenue END) AS Apr_Revenue,
    MAX(CASE WHEN month='May' THEN revenue END) AS May_Revenue,
    MAX(CASE WHEN month='Jun' THEN revenue END) AS Jun_Revenue,
    MAX(CASE WHEN month='Jul' THEN revenue END) AS Jul_Revenue,
    MAX(CASE WHEN month='Aug' THEN revenue END) AS Aug_Revenue,
    MAX(CASE WHEN month='Sep' THEN revenue END) AS Sep_Revenue,
    MAX(CASE WHEN month='Oct' THEN revenue END) AS Oct_Revenue,
    MAX(CASE WHEN month='Nov' THEN revenue END) AS Nov_Revenue,
    MAX(CASE WHEN month='Dec' THEN revenue END) AS Dec_Revenue
FROM Department GROUP BY id;

-- solution 3
SELECT
    id,
    SUM(decode(month, 'Jan', revenue, NULL)) AS Jan_Revenue,
    SUM(decode(month, 'Feb', revenue, NULL)) AS Feb_Revenue,
    SUM(decode(month, 'Mar', revenue, NULL)) AS Mar_Revenue,
    SUM(decode(month, 'Apr', revenue, NULL)) AS Apr_Revenue,
    SUM(decode(month, 'May', revenue, NULL)) AS Sep_Revenue,
    SUM(decode(month, 'Jun', revenue, NULL)) AS May_Revenue,
    SUM(decode(month, 'Jul', revenue, NULL)) AS Jun_Revenue,
    SUM(decode(month, 'Aug', revenue, NULL)) AS Jul_Revenue,
    SUM(decode(month, 'Sep', revenue, NULL)) AS Aug_Revenue,
    SUM(decode(month, 'Oct', revenue, NULL)) AS Oct_Revenue,
    SUM(decode(month, 'Nov', revenue, NULL)) AS Nov_Revenue,
    SUM(decode(month, 'Dec', revenue, NULL)) AS Dec_Revenue
FROM Department GROUP BY id;