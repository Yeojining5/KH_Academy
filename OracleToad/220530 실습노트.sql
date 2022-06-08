CREATE TABLE test1 (
t_id        varchar2(20),
t_pw        varchar2(20),
t_email     varchar2(30),
t_jumin     varchar2(20)
);

INSERT INTO test1(t_id, t_pw, t_email, t_jumin)
            VALUES('tomato', '123', 'nice_test@ho.com', '900505-1234567');

INSERT INTO test1(t_id, t_pw, t_email, t_jumin)
           VALUES('banana', '456', 'good_test@naver.com', '910505-1234567');
           
INSERT INTO test1(t_id, t_pw, t_email, t_jumin)
            VALUES('apple', '789', 'fine_test@daum.com', '920505-1234567'); 
COMMIT;

SELECT * FROM test1;

-----------------------------------------------------------------

SELECT empno FROM emp
ORDER BY empno desc
-- 정렬 order by를 사용하면 검색속도가 느려질 수밖에 없다.

SELECT /*+index_desc(emp PK_EMP) */ empno
FROM emp
-- order by 사용하지 않고 정렬하기. 이렇게 사용하는 것이 중요! 잘하는 사람

CREATE INDEX i_ename
ON emp(ename)

ename 컬럼을 가공하면(nvl) 인덱스를 사용할 수 없다.
SELECT ename FROM emp
WHERE NVL(ename, '0') = 'XXX'

인덱스가 있는 컬럼이라도 가공하면 인덱스를 사용할 수 없다.

PK는 인덱스를 제공한다. 
FK는 인덱스를 제공하지 않는다.

SELECT emp.ename, dept.deptno
FROM emp, dept
-- 14*4  총 56건 > 일어날 수 있는 모든 경우의 수 (카타시안곱)

SELECT emp.ename, dept.deptno
FROM emp, dept
WHERE emp.deptno = dept.deptno
-- 부서번호 10,20,30 데이터만 출력됨 (40은 null값이라서 출력 x)
-- 그냥 emp테이블의 데이터와 같음

SELECT emp.ename, dept.deptno
FROM emp, dept
WHERE emp.deptno(+) = dept.deptno
-- dept 테이블에는 부서번호 40번 데이터가 존재하는데,
-- emp 테이블에는 부서번호 40번을 가진 데이터가 없음
-- but (+) 사용시 40번을 불러올 수 있다.
 -- Oracle에서는 모든 행이 출력되는 테이블의 반대편 테이블의 옆에 (+) 기호를 붙여 작성해주면 된다.

SELECT dept.deptno, dept.dname, count(emp.ename)
FROM emp, dept
WHERE emp.deptno(+) = dept.deptno
GROUP BY dept.deptno, dept.dname

-------------------------------------------------

SELECT DISTINCT(deptno) FROM emp     -- 10,20,30  3건만 출력

SELECT deptno FROM emp        -- 총 14건 출력

union은 중복을 제거
union all과 다르다 (중복 출력, 합집합)