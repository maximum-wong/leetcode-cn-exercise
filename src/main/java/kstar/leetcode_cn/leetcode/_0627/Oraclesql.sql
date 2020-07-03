/* Write your PL/SQL query statement below */
-- solution 1
UPDATE salary SET sex = (CASE sex WHEN 'm' THEN 'f' ELSE 'm' END)

-- solution 2
UPDATE salary SET sex = replace('mf', sex, '');

-- solution 3
UPDATE salary SET sex = decode(sex,'m','f','m');