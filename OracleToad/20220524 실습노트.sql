우리회사에 근무하는 사원들의 급여 총액은 얼마?

SELECT sum(sal) FROM emp

SELECT 
       SUM(DECODE (JOB, 'CLERK', sal)) AS "clerk_sum",
       sum(DECODE (JOB, 'SALESMAN', sal)) AS "salesman_sum",
       sum(DECODE (JOB,  'CLERK', NULL,  'SALESMAN', NULL,  sal)) AS "etc_sum"
  FROM emp
  

<정렬>
SELECT EMPNO FROM EMP
ORDER BY EMPNO DESC

SELECT EMPNO FROM EMP
ORDER BY EMPNO ASC
  
SELECT empno FROM emp
위 문장은 인덱스로 인하여 자동 오름차 정렬되어 있음 

ORDER by를 하면 스캔한 대로 출력하지 못하고
2차 가공을 해야만 한다 = 느리다

ORDER by를 하지 않고 정렬을 할 수 있다면  nic > index의 필요성 


SELECT 
        /*+ index+desc(emp pk_emp) */ empno
  FROM emp
위 SQL문을 갈무리하여 Ctrl + E 하면 인덱스 확인 가능
hint문을 사용하여 옵티마이저에게 개발자 생각을 전달할 수 있다.
만일 오타가 있으면 무시된다.

SELECT ename FROM emp

-- 테이블에서 pk는 인덱스가 제공됨
-- 인덱스가 있는 컬럼은 테이블 access 없이 출력가능함
   [describe] - [Script] 에서도 확인 가능
--- index가 존재하는 컬럼은 테이블 액세스 없이 출력이 가능함
   ORDER BY 없이 정렬할 수 있다면 검색 속도를 높일 수 있다.
   
SELECT rowid rid FROM emp   

SELECT ename, deptno, JOB FROM emp
WHERE rowid = 'AAARE8AAEAAAACTAAD'
 위 SQL 문장은 오라클에서 제공하는 ID
 
DBMS가 가지고 있는 모든 데이터의 각각의 고유한 식별자
index테이블은 INDEX KEY 와 rowid로 구성됨
실제로 존재하지 않으며 INDEX 테이블 내에 있는 rowid(18자리)는
해당 데이터를 찾기 위한 하나의 논리적인 정보이다.
1) 6자리 : 데이터 오브젝트 번호
2) 3자리 : 상대적인 파일 번호
3) 6자리 : 블록번호
4) 3자리 : 블록 내의 행 번호

<ROWNUM>  순차적으로 번호 출력
SELECT ROWNUM, empno FROM emp
WHERE deptno = 30


<GROUP BY 절>
우리 회사에 근무하는 사원들에 대해서 부서별 사원 수를 출력
사원집합 - FK = deptno (부서집합의 pk를 가져옴)
 -- pk는 중복이 허락된다.
 -- 인덱스를 제공하지 않는다.
 -- FK는 릴레이션이다. (1:n 관계형태)

SELECT deptno, count(empno)
FROM emp
GROUP BY deptno

그룹함수 - avg, count, max, min, sum
: 테이블 전체 데이터에서 통계적인 결과를 얻기 위해서 행 집합에 적용하여 하나의 결과를 생산함

SELECT sum(sal), max(ename) FROM emp
위 문장에서 ename은 그냥 일반컬럼으로 올 수 없으므로 그룹함수를 씌운것 (전체연봉을 대표하는 사람 이름이 없기 때문)
** 또 다른 방법은 GROUP BY 절을 사용 하는 것

SELECT sum(sal), deptno FROM emp
GROUP BY deptno
-- group by에 사용한 컬럼명은 select 다음에 사용했을 때 의미가 있다. 의존관계

SELECT max(sal), avg(sal), count(JOB), JOB FROM emp
GROUP BY JOB


SELECT M.empno, M.ename, M.JOB, M.deptno,
      (SELECT T.dname FROM dept T WHERE M.deptno = T.deptno) AS dname
FROM emp M;
-- 스칼라 서브쿼리(Scalar Subquery)를 이용하여 emp테이블에 존재하지 않는 dname을 dept테이블에서 가져옴
-- select 절에 위치 (컬럼이 올 수 있는 자리)
-- 혼자 정리해본 것