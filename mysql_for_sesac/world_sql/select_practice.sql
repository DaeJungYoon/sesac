-- Active: 1732690507091@@127.0.0.1@3306@world


-- contry에 이는 모든 필드 조회
SELECT * FROM country

SELECT `Name`, `Population` FROM country;

SELECT country.`Name`,country.`Population` FROM country;

SELECT c.`Name`, c.`Population` FROM country c;

SELECT c.`Name` As 국가명, c.`Population` AS 인구수 FROM country c;
SELECT c.`Name` 국가명, c.`Population` 인구수 FROM country As c;

SELECT DISTINCT c.`Continent`, c.`Region` FROM country c;

-- name이 s로 시작하는 국가 중 인구가 1000000 이상인 나라 선택
SELECT `Name`,`Population` FROM country
WHERE `Population` > 1000000
AND `Name` LIKE BINARY'S%';


-- 인구가 800만 이상인 도시의 Name, Population을 조회하시오
SELECT `Name`,`Population` FROM city
WHERE `Population` > 8000000;
SELECT c.`Name`, c.`Population` FROM city AS c
WHERE `Population` > 8000000;
SELECT c.`Name`, c.`Population` FROM city c
WHERE `Population` > 8000000;

SELECT * FROM city;

-- 한국(KOR)에 있는 도시의 Name, CountryCode를 조회하시오
SELECT `Name`, `CountryCode` FROM city
WHERE `CountryCode` = 'kor';
SELECT c.`Name`, c.`CountryCode` FROM city AS c
WHERE c.`CountryCode` = 'kor';
SELECT c.`Name`, c.`CountryCode` FROM city c
WHERE c.`CountryCode` = 'kor';

-- c.을 하는 이유는 나중에 조인할 때 id를 명시함으로 테이블 간의 혼동을 방지하기 위해
SELECT * FROM city ct

-- 이름이 'San'으로 시작하는 도시의 Name을 조회하시오
SELECT `Name` FROM city
WHERE `Name` LIKE 'San%';
SELECT c.`Name` FROM city AS c
WHERE `Name` LIKE 'san%';
SELECT c.`Name` FROM city c
WHERE c.`Name` LIKE 'san%';

-- 인구가 100만에서 200만 사이인 한국 도시의 Name을 조회하시오
SELECT `Name` FROM city
WHERE `Population` BETWEEN 1000000 AND 2000000
AND `CountryCode` LIKE 'kor';
SELECT c.`Name` FROM city AS c
WHERE c.`Population` BETWEEN 1000000 AND 2000000
AND c.`CountryCode` LIKE 'kor';
SELECT c.`Name` FROM city c
WHERE c.`Population` BETWEEN 1000000 AND 2000000
AND c.`CountryCode` LIKE 'kor';


-- 인구가 500만 이상인 한국, 일본, 중국의 도시의 Name, CountryCode, Population 을 조회하시오
SELECT `Name`, `CountryCode`, `Population` FROM city
WHERE `Population` > 5000000
AND `CountryCode`='kor' OR `CountryCode`='jpn' OR `CountryCode`='chn';
SELECT `Name`, `CountryCode`, `Population` FROM city
WHERE `Population` > 5000000
AND `CountryCode` IN ('kor', 'jpn', 'chn');
-- SELECT * FROM country c
-- WHERE c.`Continent` = 'asia';
SELECT c.`Name`, c.`CountryCode`, c.`Population` FROM city AS c
WHERE c.`Population` > 5000000;
AND c.`CountryCode` IN ('kor', 'jpn', 'chn')
SELECT c.`Name`, c.`CountryCode`,c.`Population` FROM city c
WHERE c.`Population` > 5000000
AND c.`CountryCode` IN ('kor', 'jpn', 'chn')

-- 오세아니아 대륙에서 예상 수명의 데이터가 없는 나라의 Name, LifeExpectancy, Continent를 조회하시오.
SELECT `Name`, `LifeExpectancy`, `Continent` FROM country
WHERE `Continent` LIKE 'oceania'
AND GNPOld is NULL;
