-- Active: 1732694339715@@127.0.0.1@3306@sakila

-- 1. 배우가 출연한 영화의 제목을 조회
    -- 배우 / 영화
-- 배우가 출연한 영화가 하나도 없으면
-- INNER JOIN - 배우가 안보인다.
-- LEFT JOIN - 배우가 보인다.
SELECT a.first_name, a.last_name, f.title
FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
JOIN film f ON fa.film_id = f.film_id

    
-- 2. first_name이 `PENELOPE` 인 배우가 출연한 영화의 제목을 조회
-- first_name이 `PENELOPE` 인 
-- 배우가 출연한 영화의 제목을 조회
SELECT a.first_name, a.last_name, f.title
FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
JOIN film f ON fa.film_id = f.film_id
WHERE a.first_name = 'PENELOPE';

    
-- 3. 영화 별 출연 배우의 수를 조회
-- 영화 별 
-- 출연 배우의 수
SELECT f.title, COUNT(a.actor_id) AS actor_count
FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
JOIN film f ON fa.film_id = f.film_id
GROUP BY f.film_id;
    
-- 4. 영화 별 출연 배우의 수가 5가 넘는 데이터를 배우의 수가 큰순으로 조회
-- 영화 별 
-- 출연 배우의 수가 5가 넘는 
-- 데이터를 배우의 수가 큰순으로 조회
SELECT f.title, COUNT(a.actor_id) AS actor_count
FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
JOIN film f ON fa.film_id = f.film_id
GROUP BY f.film_id
HAVING actor_count > 5
ORDER BY actor_count DESC;
-- ---
SELECT f.title, COUNT(fa.actor_id) AS actor_count
-- FROM actor a
-- JOIN film_actor fa ON a.actor_id = fa.actor_id
-- JOIN film f ON fa.film_id = f.film_id
FROM film f
JOIN film_actor fa ON f.film_id = fa.film_id
GROUP BY f.film_id
HAVING actor_count > 5
ORDER BY actor_count DESC;

----------------------------------------------------------------------------------------

-- 5. 고객의 대여 정보 조회
SELECT c.last_name, r.rental_date, r.return_date
FROM customer c
LEFT JOIN rental r ON c.customer_id = r.customer_id

-- 6. 고객이 대여한 영화 정보 조회
-- 고객 - 대여 - inventory - 영화
SELECT c.last_name, f.title
FROM customer c
LEFT JOIN rental r ON c.customer_id = r.customer_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id

-- 7. `YENTL IDAHO` 영화를 대여한 고객 정보 조회
SELECT c.last_name, f.title
FROM customer c
LEFT JOIN rental r ON c.customer_id = r.customer_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id
WHERE f.title = 'YENTL IDAHO'

-- ---

-- 8. 배우별로 출연한 영화의 등급(rating)을 조회
SELECT a.first_name, a.last_name, f.title, f.rating
FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
JOIN film f ON fa.film_id = f.film_id;

-- 9. 
-- 1번 고객이             customer id가 1번
-- 자주 대여한            rental, 자주니까 개수를 세야지 => count => grouping
-- 영화의                 film
-- 카테고리를 찾으시오     film의 카테고리 => 자주 ~~ 카테고리`의` category로 grouping
SELECT cu.last_name, ca.name, COUNT(*) AS rental_count_per_category
FROM customer cu
LEFT JOIN rental r ON cu.customer_id = r.customer_id -- 왜 LEFT냐? => 1번 고객이 빌린 영화가 없어도 조회가 되면 좋겠기 때문
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category ca ON fc.category_id = ca.category_id
WHERE cu.customer_id = 1
GROUP BY ca.category_id
ORDER BY rental_count_per_category DESC;

-- 1. 각 직원이 일하는 매장의 주소와 도시를 조회
SELECT sta.last_name, a.address, c.city
FROM staff sta
JOIN store sto ON sta.store_id = sto.store_id
JOIN address a ON sto.address_id = a.address_id
JOIN city c ON a.city_id = c.city_id;

-- 11. 고객별로 대여한 영화 제목과 지불한 금액, 날짜를 조회
-- 고객별로
--  대여한 영화 
--  제목과 
--  지불한 금액, 
--  날짜를 조회
SELECT c.last_name, f.title, p.amount, p.payment_date AS 돈낸날짜, r.rental_date AS 빌린날짜
FROM customer c
JOIN rental r ON c.customer_id = r.customer_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id
JOIN payment p ON r.rental_id = p.rental_id;

-- 12. 국가별 고객 수를 조회

SELECT co.country, COUNT(cu.customer_id) AS customer_count
FROM customer cu
JOIN address a ON cu.address_id = a.address_id
JOIN city ci ON a.city_id = ci.city_id
JOIN country co ON ci.country_id = co.country_id
GROUP BY co.country_id