* 220607 실습노트

EQUAL JOIN
: Equal(=) 조건으로 join하는 방식

[문제]
temp에서 사번, 성명, 부서코드를 읽어내는데 부서명칭을 함께 보고 싶은 경우

SELECT T.emp_id, T.emp_name, d.dept_name
FROM temp T,
     tdept d
WHERE T.dept_code = d.dept_code
--- 고전적인 방법



SELECT T.emp_id, T.emp_name, d.dept_name
  FROM temp T JOIN tdept d
    ON T.dept_code = d.dept_code
-- 최근 문법


SELECT emp_id, emp_name, dept_name
FROM temp NATURAL JOIN tdept
-- NATURAL JOIN  -- 식별자를 사용하지x (개발자들이 선호하지는x)


-- INNER JOIN 조건을 만족하는 행만 질의 결과로 가져온다.


연습문제
tcom의  work_year가 2001인 자료와 temp를 사번으로 연결해서 조인한 후
comm을 받는 직원의 성명, salary+com을 조회하는 sql문을 작성하시오.

SELECT A.work_year, B.emp_name, (B.salary + A.comm) total
  FROM tcom A, 
       temp B
 WHERE A.work_year = 2001
   AND A.emp_id = B.emp_id
   
   -------------------------------------------------------
   
 NON-EQUAL 조인
 : 조인 조건이 =이 아닌 다른 연산기호로 주어지는 경우 (BETWEEN, >, >=, <, <=)
 
temp와 emp_level을 이용해 emp_level의 과장 직급의 
연봉 상한/하한 범위 내에 드는 직원의 사번과 성명, 직급, salary를 읽어오는 sql문 작성

SELECT A.emp_id, A.emp_name, A.lev, A.salary
  FROM temp A,
       emp_level B
 WHERE A.salary BETWEEN from_sal AND to_sal
  AND B.lev = '과장'
  
  -----------------------------------------------
  
  OUTER JOIN
  : 두 개 이상의 테이블 조인시 한쪽 테이블의 행에 대해 다른쪽 테이블에 일치하는 행이 없더라도
   다른쪽 테이블의 행을 null로 하여 행을 RETURN 하는 것이 OUTER join이다.
   Oracle에서는 모든 행이 출력되는 테이블의 반대편 테이블 옆에 (+) 기호를 붙여주면 같은 결과(WHERE 절)
  
각 사번의 성명, salary, 연봉 하한금액, 연봉 상한금액을 보고자 한다.
temp와 emp_level을 조인하여 결과를 보여주되, 연봉의 상하한이 등록되어 있지 않은
수습 사원은 성명, salary 까지만 이라도 나올 수 있도록 쿼리문 작성

SELECT A.lev, A.emp_name, A.salary, B.from_sal, B.to_sal
  FROM temp A LEFT OUTER JOIN emp_level B
    ON A.lev = B.lev
    
SELECT A.lev, A.emp_name, A.salary, B.from_sal, B.to_sal
  FROM temp A,
       emp_level B
WHERE A.lev = B.lev(+)

----------------------------------------------

self JOIN


tdept 테이블에 자신의 상위 부서정보를 관리하고 있다
이 테이블을 이용하여 부서코드, 부서명, 상위부서코드, 상위부서명을 읽어오는 쿼리 작성

SELECT 
        A.dept_code AS "부서코드",
        A.dept_name AS "부서명",
        b.dept_code AS "상위부서코드",
        b.dept_name AS "상위부서명"
   FROM tdept A, tdept b
   WHERE b.dept_code = A.parent_dept

  
