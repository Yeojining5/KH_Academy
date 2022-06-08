20220531 강의노트

SELECT * FROM lecture

문제:주당 강의 시간과 학점이 같으면 '일반'을 돌려 받으려 한다
어떻게 해야 하는가?

SELECT decode(lec_time, lec_point, '일반')
FROM lecture;

-------------------------------------------------
  
문제:주당강의시간과 학점이 같은 강의의 숫자를 알고 싶다.
어떻게 해야 하는가?

SELECT count(lec_id)
FROM lecture
WHERE lec_time = lec_point

SELECT count(decode(lec_time, lec_point, lec_id))
FROM lecture
WHERE lec_time = lec_point

---------------------------------------------------  
  
문제: 강의 시간과 학점이 같으면 '일반'을 리턴받은 후 정렬도
하고 싶은 경우에는 어떻게 해야 하는가?

SELECT decode(lec_time, lec_point, '일반')
FROM lecture
ORDER BY decode(lec_time, lec_point, '일반')

-----------------------------------------------------
 
주당 강의 시간과 학점이 같으면 '일반' 과 '교양'을 리턴받은 후 
정렬도 하고 싶은 경우에는 어떻게 해야하는가?


SELECT sign(5), sign(-600), sign(10-50) FROM dual

SELECT
       lec_id, lec_time, lec_point
       , DECODE(sign(lec_time-lec_point),1,'실험과목'
                                        ,0,'일반과목'
                                        ,-1,'기타과목') AS "과목유형"
 FROM lecture

-------------------------------------------------------------

문제:강의 시간과 학점이 다르면 NULL이 리턴되는 대신 '특별'이라고
리턴되도록 하려면 어떻게 해야하는가?

SELECT decode(lec_time, lec_point, '일반', '특별')
FROM lecture






SELECT to_char(sysdate, 'DD')
, to_char(sysdate, 'MM')
, to_char(sysdate, 'DAY')
FROM dual

SELECT '31'||'11' FROM dual


______________________________________________________________

월요일에는 해당 일자에 01을 붙여서 4자리 암호를 만들고
화요일에는 11, 수요일에는 21, 목요일에는 31, 금요일에는 41, 토 51 일 61
붙여서 4자리 암호를 만든다고 할 때, 암호를 select하는 sql을 만들어 보시오

SELECT to_char(sysdate,'DD'),
       to_char(sysdate,'DD') || decode(to_char(sysdate,'DAY'), '월요일', 01, 
                                                               '화요일', 11, 
                                                               '수요일', 21, 
                                                               '목요일', 31, 
                                                               '금요일', 41, 
                                                               '토요일', 51, 
                                                               '일요일', 61) 암호
  FROM dual
  
  
  
 -----------------------------------------------------
 
 실전문제
 사원 테이블에서 job이 'CLERK'인 사원의 급여 합, 'SALESMAN'인 사람의 급여의 합을 구하고
 나머지 job에 대해서는 기타의 합으로 구하시오.
 
 SELECT * FROM emp
 
 SELECT JOB, sum(sal) 
  FROM emp 
GROUP BY JOB
HAVING JOB = 'CLERK' OR JOB = 'SALESMAN'


SELECT decode(JOB, 'CLERK', sal, NULL)
      ,decode(JOB, 'SALESMAN', sal, NULL)
      ,decode(JOB, 'CLERK',NULL, 'SALESMAN', NULL, sal)
  FROM emp


// 최종
SELECT sum(decode(JOB, 'CLERK', sal, NULL)) AS "CLERK_SUM"
      ,sum(decode(JOB, 'SALESMAN', sal, NULL)) AS "SALESMAN_SUM"
      ,sum(decode(JOB, 'CLERK',NULL, 'SALESMAN', NULL, sal)) AS "ETC_SUM"
  FROM emp
  
  --------------------------------------------------
  
  SELECT * FROM member
  아이디가 몇개? 아이디가 존재하니? 
  회원가입 시 아이디 중복검사 쿼리문을 작성해본다.
  
  SELECT count(mem_id)
  FROM member
  WHERE mem_id =:x
  
  SELECT 1 FROM member
  WHERE mem_id = 'apple'
  
서브쿼리는  where절 아래 select문을 말한다.
인라인뷰는  from절 아래 select문

SELECT 1
FROM dual
WHERE EXISTS (SELECT MEM_NAME
                FROM MEMBER
               WHERE MEM_ID='apple')
              
SELECT nvl(hobby, '없음') FROM temp

SELECT nvl(
            (SELECT 1
              FROM dual
               WHERE EXISTS (SELECT MEM_NAME
                FROM MEMBER
               WHERE MEM_ID='apple')),0)
  FROM dual