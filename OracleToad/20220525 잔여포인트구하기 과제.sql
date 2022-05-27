문제1
영화 티켓을 받을 수 있는 사람의 명단과 현재 가지고 있는 포인트, 
영화 티켓의 포인트 그리고 그 티켓을 사용한 후 남은 예상 포인트를 출력하시오.

SELECT M.name_vc "이름",
       M.point_nu "보유",
       P.point_nu "적용",
       M.point_nu - P.point_nu "남은 예상"
  FROM t_giftmem M,
       (SELECT point_nu
          FROM t_giftpoint
         WHERE name_vc = '영화티켓') P
 WHERE M.point_nu >= 15000;
 
 
SELECT M.name_vc "이름",
       to_char(M.point_nu, '999,999')||'원' "보유",
       to_char(P.point_nu, '999,999')||'원' "적용",
       to_char(M.point_nu - P.point_nu, '999,999')||'원' "남은 예상"
  FROM t_giftmem M,
       (SELECT point_nu
          FROM t_giftpoint
         WHERE name_vc = '영화티켓') P
 WHERE M.point_nu >= 15000;
 
  
___________________________________________________________

문제2
김유신씨가 보유하고 있는 마일리지 포인트로 얻을 수 있는 상품 중
가장 포인트가 높은 것은 무엇인가?


SELECT name_vc, point_nu
  FROM (SELECT name_vc, point_nu
          FROM t_giftpoint
         WHERE point_nu <= 50012
      ORDER BY point_nu desc)
  WHERE ROWNUM = 1;

----------------------------------------위까지 내 풀이


1) 
t_giftmem - 회원 5명
t_giftitem - 상품 6가지

SELECT *
  FROM t_giftmem, t_giftpoint -- 5*6 총 30가지 출력
  
  이 30가지 경우의 수에서 조건은 2가지를 만족해야 한다.
  1. 영화티켓(인라인뷰)   AND   2. M.pint_nu >= P.point_nu(조건절)
 
SELECT point_nu
  FROM t_giftpoint
  WHERE name_vc = '영화티켓'
  -- 1억가지 경우의 수가 있다고 생각하여 조회를 할 것
  -- 이 구문을 인라인뷰로 넣는다 - 옵티마이저의 일을 줄여주기 위해
 
 
  
SELECT M.name_vc "이름",
       M.point_nu "보유",
       P.point_nu "적용",
       M.point_nu - P.point_nu "남은 예상"
  FROM t_giftmem M, t_giftpoint P 
  
SELECT M.name_vc "이름",
       M.point_nu "보유",
       P.point_nu "적용",
       M.point_nu - P.point_nu "남은 예상"
  FROM t_giftmem M,
       (SELECT point_nu
          FROM t_giftpoint
         WHERE name_vc = '영화티켓') P
 WHERE M.point_nu >= P.point_nu;  
 -- >= 15000  이라는 상수보다는 변수를 사용할 것!!!
 -- 인라인뷰를 사용하지 않는다면 wherer 조건1 and 조건2 이런식으로 들어감

SELECT M.name_vc "이름",
       M.point_nu "보유",
       P.point_nu "적용",
       M.point_nu - P.point_nu "남은 예상"
  FROM t_giftmem M, t_giftpoint P
 WHERE M.point_nu >= P.point_nu  
     AND P.name_vc =:x
     -- 변수처리 > 변수 x는 UI에서 가져온다 ******
 
 2)
 where절 밑에 존재 > 서브쿼리
 
SELECT point_nu FROM t_giftmem WHERE name_vc = '김유신'
 
-- 변수로 치환하기
SELECT point_nu FROM t_giftmem WHERE name_vc =:NAME


SELECT max(point_nu)
  FROM t_giftpoint
 WHERE point_nu <= ( 
                    SELECT point_nu 
                    FROM t_giftmem 
                    WHERE name_vc = '김유신'
                    )
-- 위 sql문은 50,000을 출력함
-- 그룹함수와 일반컬럼은 같이 사용할 수 없다.
-- 위 select 문에 name_vc를 추가하면 "단일 그룹의 그룹 함수가 아닙니다"
-- 억지로 name_vc 에 max min을 씌우면 안된다.


-- 우리가 찾는 답는 한과세트 50000 !
SELECT name_vc, point_nu
FROM t_giftpoint
WHERE point_nu = ( 서브쿼리 - 50,000출력되는 얘를 가져와라 )

SELECT name_vc, point_nu
FROM t_giftpoint
WHERE point_nu = (
                SELECT max(point_nu)
                  FROM t_giftpoint
                  WHERE point_nu <= ( 
                                    SELECT point_nu 
                                      FROM t_giftmem 
                                      WHERE name_vc = '김유신'
                                    ) )
 -- 서브쿼리                                    
                                    
 -----------------------------------------------
 
 SELECT ename
FROM emp
WHERE ename LIKE 'S%'

SELECT ename
FROM emp
WHERE ename LIKE '%S'

SELECT ename
FROM emp
WHERE ename LIKE '%S%'

SELECT ename, sal
FROM emp
WHERE sal > 1000
AND sal < 3000
-- 구간 조건
-- between A and B 로 표현 가능

SELECT ename, sal
FROM emp
WHERE sal BETWEEN 1000 AND 3000