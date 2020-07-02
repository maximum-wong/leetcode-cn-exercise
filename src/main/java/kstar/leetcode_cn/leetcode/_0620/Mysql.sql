# Write your MySQL query statement below
-- solution 1
SELECT id, movie, description, rating FROM cinema WHERE id&1=1 AND description<>'boring' ORDER BY rating DESC;

-- solution 2
SELECT id, movie, description, rating FROM cinema WHERE MOD(id, 2)<>0 AND description<>'boring' ORDER BY rating DESC;