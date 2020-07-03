/* Write your T-SQL query statement below */
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
SELECT id,
    [Jan] AS [Jan_Revenue],
    [Feb] AS [Feb_Revenue],
    [Mar] AS [Mar_Revenue],
    [Apr] AS [Apr_Revenue],
    [May] AS [May_Revenue],
    [Jun] AS [Jun_Revenue],
    [Jul] AS [Jul_Revenue],
    [Aug] AS [Aug_Revenue],
    [Sep] AS [Sep_Revenue],
    [Oct] AS [Oct_Revenue],
    [Nov] AS [Nov_Revenue],
    [Dec] AS [Dec_Revenue] 
FROM Department PIVOT
(SUM(revenue) FOR month 
    IN([Jan],[Feb],[Mar],[Apr],[May],[Jun],[Jul],[Aug],[Sep],[Oct],[Nov],[Dec]))
 AS T;