-- Active: 1732690507091@@127.0.0.1@3306@world
-- 대륙 별 국가 수가 20개가 넘는 대륙, 국가 수 조회
SELECT `Continent`, count(*) as country_count 
FROM country 
GROUP BY `Continent`
HAVING country_count>20;

-- Region 별 평균 인구가 10000000이 넘는 지역, 평균 인구 조회
SELECT `Region`, AVG(`Population`) as country_population
FROM country
GROUP BY `Region`
HAVING country_population > 10000000;
-- 대륙 별 인구가 1000만 이상인 국가의 수가 10개가 넘는 대륙, 국가 수 조회
SELECT `Continent`, COUNT(*) as country_count 
FROM country
WHERE `Population`>10000000
GROUP BY `Continent`
HAVING country_count>10;

-- 평균 인구수가 10000000 이 넘는 대륙 의 국가 수 
  -- HAVING절에는 SELECT절에 포함되지 않는 집계함수가 포함될 수 있다.
SELECT `Continent`, COUNT(*) as country_count
FROM country
GROUP BY `Continent`
HAVING AVG(`Population`)>10000000;

-- 각 국가별 도시가 10개 이상인 국가의 CountryCode, 도시 수를 조회하시오. - city
SELECT `CountryCode`, COUNT(*) city_count
FROM city
GROUP BY `CountryCode`
HAVING city_count >=10
-- HAVING COUNT(city_count)>=10;
-- HAVING COUNT(*)>=10;

-- 실습

-- District별 평균 인구가 100만 이상이면서 도시 수가 3개 이상인 District,  도시 수, 총 인구를 구하시오 - city
SELECT * FROM city;
SELECT `District`, COUNT(*) as city_count, SUM(`Population`) as city_sum
FROM city 
GROUP BY `District`
HAVING city_count>3 
AND AVG(`Population`) >= 1000000;


-- 아시아 대륙의 국가들 중에서, Region별 평균 GNP가 1000 이상인 Region,  평균 GNP를 조회하시오 - country
SELECT c.`Region` ,AVG(c.`GNP`) as country_gnp
FROM country c
WHERE `Continent` = ("asia")
GROUP BY c.`Region`
HAVING AVG(c.`GNP`)>=1000

-- 독립년도가 1900년 이후인 국가들 중에서, 대륙별 평균 기대수명이 70세 이상인 Continent, 평균 기대수명을 조회하시오. - country
SELECT c.`Continent`, AVG(c.`LifeExpectancy`) as avg_life
FROM country c
WHERE c.`IndepYear` >1900
GROUP BY c.`Continent`
HAVING avg_life >=70;

-- CountryCode별 도시 평균 인구가 100만 이상이고 도시 최소 인구가 50만 이상인 CountryCode, 총 도시수, 총 인구수를 조회하시오. - city`
SELECT c.`CountryCode`, COUNT(*) as `총 도시 수`, SUM(c.`Population`) as `총 인구 수`
FROM city as c
GROUP BY c.`CountryCode`
HAVING AVG(c.`Population`)>=1000000 AND MIN(c.`Population`)>=500000;

