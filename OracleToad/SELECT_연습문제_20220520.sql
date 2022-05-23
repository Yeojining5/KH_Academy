1.월 급여는 연봉을 18로 나누어 홀수 달에는 연봉의 1/18이 지급되고, 짝수달에는 연봉의 2/18가 지급된다고 가정했을 때 홀수 달과 짝수 달에 받을 금액을 나타내시오.
SELECT emp_name,
       ROUND (salary / 18, 1) "월급(홀수)",
       ROUND (salary / 9, 1) "월급(짝수)",
       lev
  FROM temp;  
-----------------------------------위는 내풀이
SELECT emp_name,
       salary,
       to_char(round(salary / 18, -1), '999,999,999')||'원' "홀수달 급여",
       to_char(round(salary / 9, -1),'999,999,999')||'원' "짝수달 급여"
  FROM temp

* 숫자형을 문자형으로 전환해주는 함수 > To_CHAR
to_char(날짜, 'yyyymmdd')
to_char(500000,'999,999,999')
SELECT 550000, to_char(550000, '999,999'), to_char(55000000, '999,999,999')
FROM dual

SELECT ROUND (1234567.456, 1),    // 1234567.5
       ROUND (1234567.456, -1),   // 1234570
       ROUND (1234567.456, 2)     // 1234567.46
  FROM DUAL


2.위에서 구한 월 급여에 교통비가 10만원씩 지급된다면(짝수달은 20만원)위의 문장이 
어떻게 바뀔지 작성해 보시오.
SELECT emp_name,
       ROUND (salary / 18, 1) + 100000 AS "월급(홀수+교통비)",
       ROUND (salary / 9, 1) + 200000 AS "월급(짝수+교통비)",
       lev
  FROM temp;
  -------------------------------------
  SELECT emp_name,
       salary,
       to_char(round(salary / 18, -1)+100000, '999,999,999')||'원' "홀수달 급여",
       to_char(round(salary / 9, -1)+200000,'999,999,999')||'원' "짝수달 급여"
  FROM temp


3.TEMP 테이블에서 취미가 NULL 이 아닌 사람의 성명을 읽어오시오.
SELECT emp_name
  FROM temp
 WHERE hobby IS NOT NULL;
------------------------------------------
null은 모른다, 결정되지 않았다, 그래서 연산대상이 아니다

emp 테이블중, 사원 중에서 인센티브를 받는 사원의 이름, 인센티브액을 출력
SELECT ename, comm
FROM emp
WHERE comm IS NOT NULL

SELECT ename, comm
FROM emp
WHERE comm <> 0

SELECT ename, comm
FROM emp
WHERE comm > 0

SELECT ename, sal FROM emp

사원 중에서 부서번호가 10 OR 30인 사원의 이름과 부서번호 출력
  SELECT ename, deptno
    FROM emp
   WHERE deptno = 10 OR deptno = 30    >> 점조건, 선분조건
ORDER BY deptno

  SELECT ename, deptno
    FROM emp
   WHERE deptno IN (10, 30)    >> 개발자들 사이에서 더 일반적인 것임

  SELECT ename, deptno
    FROM emp
   WHERE deptno = 10
   UNION ALL
     SELECT ename, deptno
    FROM emp
   WHERE deptno = 30


4.TEMP 테이블에서 취미가 NULL인 사람은 모두 HOBBY를 “없음”이라고 값을 치환하여 가져오고 나머지는 그대로 값을 읽어오시오.
SELECT emp_name, NVL (hobby, '없음') AS HOBBY 
  FROM temp;
-- NVL 함수는 실제 테이블에 값을 반영하는 것은 아니다. Null을 체크함


5.TEMP의 자료 중 HOBBY의 값이 NULL인 사원을 ‘등산’으로 치환했을 때 HOBBY가 ‘등산인 사람의 성명을 가져오는 문장을 작성하시오.
SELECT emp_name, NVL (hobby, '등산') AS HOBBY
  FROM temp
 WHERE hobby IS NULL OR hobby = '등산';


6.TEMP의 자료 중 EMP_ID와 EMP_NAME을 각각 ‘사번’,’성명’으로 표시되어 DISPLAY되도록 COLUMN ALLIAS를 부여하여 SELECT 하시오.
SELECT emp_id 사번, emp_name 성명 
  FROM temp;



7.TEMP의 자료를 직급 명(LEV)에 ASCENDING하면서 결과내에서 다시 사번 순으로 
DESCENDING하게 하는 ORDER BY하는 문장을 만들어 보시오.
  SELECT *
    FROM temp
ORDER BY lev ASC, emp_id DESC;