-- Active: 1732690507091@@127.0.0.1@3306@practice
CREATE TABLE student(
  -- 컬럼이름: 도메인 : 제야조건
  student_id VARCHAR(7) PRIMARY KEY,
  name VARCHAR(10),
  grade INT,
  major VARCHAR(20)
);
-- 외래키가 있는 테이블 생성
CREATE TABLE attendance (
    attendance_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id VARCHAR(7) REFERENCES student(student_id),
    date DATE,
    status VARCHAR(10)
);

ALTER TABLE student
ADD phone VARCHAR(20),
MODIFY name VARCHAR(100) NOT NULL;

ALTER TABLE student 
DROP COLUMN phone;

INSERT INTO student (student_id, name, grade, major)
VALUES('2024001','김철수', 1, '컴공');

INSERT INTO student VALUES 
    ('2024002', '이영희', 2, '경영학'),
    ('2024003', '박민수', 3, '물리학');


SELECT * FROM student;

SELECT name FROM student;
SELECT s.name FROM student s;
SELECT * FROM student WHERE grade=1;


UPDATE student SET grade=2, major='경제' WHERE name='박민수';


DELETE FROM student WHERE student_id='2024002';