/* Write your T-SQL query statement below */
-- solution 1
UPDATE salary SET sex = CASE sex WHEN 'f' THEN 'm' ELSE 'f' END;

-- solution 2
UPDATE salary SET sex = char(ascii('m')+ascii('f')-ascii(sex));

-- solution 3
UPDATE salary SET sex = char(ascii('m')^ascii('f')^ascii(sex));

-- solution 4
UPDATE salary SET sex = replace('mf', sex, '');