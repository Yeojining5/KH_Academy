2022602 실습노트

CREATE VIEW v_emp1(e_no, e_name)
AS SELECT empno, ename
     FROM emp
    WHERE deptno = 10
    
-- ALLEN 
SELECT sal FROM emp WHERE ename = 'ALLEN'

SELECT ename, sal
 FROM emp
 WHERE sal > (
                SELECT sal FROM emp WHERE ename = 'ALLEN'
              )
              
-------------------------------------------

서브쿼리 연습문제

1.temp에서 연봉이 가장 많은 직원의 row를 찾아서 이 금액과 동일한 금액을
받는 직원의 사번과 성명을 출력하시오.

SELECT salary FROM temp ORDER BY salary desc

SELECT emp_id, emp_name, salary
FROM (
     SELECT emp_id, emp_name, salary
       FROM temp
   ORDER BY salary DESC
      )
WHERE ROWNUM = 1
-----

SELECT max(salary) FROM temp

SELECT emp_id, emp_name
FROM temp
WHERE salary = (
                SELECT max(salary) FROM temp
                )


2.temp의 자료를 이용하여 salary의 평균을 구하고 이보다 큰 금액을 salary로
받는 직원의 사번과 성명, 연봉을 보여주시오.

SELECT emp_id, emp_name, salary
  FROM temp
  WHERE salary > (
               SELECT avg(salary) FROM temp
               )


3.temp의 직원 중 인천에 근무하는 직원의 사번과 성명을 읽어오는 SQL을 서브
쿼리를 이용해 만들어보시오.

SELECT emp_id, emp_name
FROM temp
WHERE dept_code IN (
                    SELECT dept_code 
                    FROM tdept 
                    WHERE area = '인천'
                    )
                    

4.tcom에 연봉 외에 커미션을 받는 직원의 사번이 보관되어 있다.
이 정보를 서브쿼리로 select하여 부서 명칭별로 커미션을 받는
인원수를 세는 문장을 만들어 보시오.

SELECT emp_id FROM tcom

SELECT dept_code
FROM temp
WHERE emp_id IN (
                 SELECT emp_id 
                 FROM tcom 
                 )


SELECT dept_code, count(emp_id)
FROM temp
WHERE emp_id IN (
                 SELECT emp_id 
                 FROM tcom 
                 )
GROUP BY dept_code


-- 최종
SELECT dept_name, count(emp_id)
FROM temp, tdept
WHERE emp_id IN (
                 SELECT emp_id 
                 FROM tcom
                 )
 AND TEMP.DEPT_CODE = tdept.dept_code
GROUP BY dept_name      


---------------------------------------------------
* CASE문 연습문제

temp의 자료를 salary로 분류하여 등급별 인원수를 출력하는 sql문 작성 
3천만원 이하는 D / 3천 초과 5천 이하는 C / 5천 초과 7천 이하는 B / 7천 초과는 A 

SELECT 
      count(CASE WHEN salary <= 30000000 THEN 'D'END) AS D
           ,count(CASE WHEN salary BETWEEN 30000001 AND 50000000 THEN 'C'END) AS C
           ,count(CASE WHEN salary BETWEEN 50000001 AND 70000000 THEN 'B'END) AS B
           ,count(CASE WHEN salary > 70000000 THEN 'A'END) AS A     
FROM temp



아이디와 비번이 일치하면 1을 반환, 비번이 틀리면 0을 반환, 아이디가 존재하지 않으면 -1을
반환하는 select문을 작성하시오 (case구문 사용)


SELECT
    CASE WHEN mem_id=:ID THEN
      CASE WHEN mem_pw=:pw THEN 1
        ELSE 0
      END
    ELSE -1
    END AS result
  FROM member


SELECT result
 FROM  (
      SELECT
         CASE WHEN mem_id=:ID THEN
           CASE WHEN mem_pw=:pw THEN 1
             ELSE 0
           END
      ELSE -1
      END AS result
  FROM member
  ORDER BY result desc
         )
WHERE ROWNUM = 1 
    
        

 
      
 

                
