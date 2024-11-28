-- -- Active: 1732690507091@@127.0.0.1@3306@world
-- country 테이블에서 대륙별로 정렬하고, 같은 대륙 내에서는 GNP가 높은 순으로 정렬하여 Name, Continent, GNP을 조회하시오
SELECT c.Continent, c.Name, c.GNP
FROM country c
ORDER BY c.Continent, c.GNP DESC;

-- - country 테이블에서 기대수명이 짧은 순으로 정렬하되, NULL값은 마지막에 나오도록 정렬하여 Name, LifeExpectancy을 조회하시오
SELECT c.Name, c.LifeExpectancy
FROM country c
ORDER BY c.LifeExpectancy IS NULL,c.LifeExpectancy

-- 대륙 별 국가 수가 많은 순서대로 Continent, 국가 수를 조회하시오.
SELECT c.Continent, COUNT(c.Continent) as country_count
FROM country c
GROUP BY c.Continent
ORDER BY country_count DESC; 

-- 독립년도가 있는 국가들의 대륙 별 평균 기대수명이 높은 순서대로 Continent, 평균 기대수명을 조회하시오
SELECT c.Continent, AVG(c.LifeExpectancy) as continent_avg
FROM country c
WHERE c.IndepYear IS not NULL
GROUP BY c.Continent
ORDER BY continent_avg DESC;