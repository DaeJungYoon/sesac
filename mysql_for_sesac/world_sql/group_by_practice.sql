-- Active: 1732690507091@@127.0.0.1@3306@world
SELECT Continent, COUNT(*) as country_count
FROM country
GROUP BY Continent;

-- 대륙별 총 인구수를 구하시오. - country
SELECT Continent, SUM(Population) as country_population
FROM country
WHERE `Population` 
GROUP BY continent;
SELECT c.`Continent`, SUM(c.`Population`) total_pop FROM country c
GROUP BY c.`Continent`;

-- Region별로 GNP가 가장 높은 Region를 찾으시오 - country
SELECT Region, MAX(`GNP`) as country_region_highest_gnp
FROM country
WHERE `GNP`
GROUP BY Region;
SELECT c.`Region`, MAX(`GNP`) FROM country c
GROUP BY `Region`;

-- 대륙별 평균 GNP와 평균 인구를 구하시오 - counyry
SELECT c.`Continent`, AVG(c.`GNP`), AVG(c.`Population`) FROM country c
GROUP BY c. `Continent`;

-- 인구가 50만에서 100만 사이인 도시들에 대해, District별 도시 수를 구하시오 - city
SELECT c.`District`, COUNT(*) FROM city c
WHERE `Population` BETWEEN 500000 AND 1000000
GROUP BY c.`District`;

-- 아시아 대륙 국가들의 Region별 총 GNP를 구하세요 - country
SELECT c.`Region`, SUM(`GNP`) FROM country c
WHERE `Continent` LIKE 'asia'--성능이 안 좋을 것 같음
GROUP BY c.`Region`; 

SELECT c.`Region`, SUM(`GNP`) FROM country c
WHERE `Continent` = 'asia'
GROUP BY c.`Region`;

