SELECT deptno, dname, loc FROM dept

SELECT empno, ename, JOB, mgr, hiredate, comm, sal, deptno FROM emp

-- 테이블에 저장된 내용 삭제하기
무결성 제약조건(FK_DEPTNO) 때문에 삭제가 불가하다.
마음대로 삭제가 불가하다 = 데이터를 안전하게 보관 가능
인덱스가 제공된다 (색인, 검색속도 빠름)

DELETE FROM dept

DELETE FROM emp

ROLLBACK

dept테이블에서 deptno는 pk이고 - 기본키
emp테이블에서 deptno는 fk이다 - 외래키

SELECT empno
  FROM emp
 WHERE ename = 'SCOTT';

함수명(컬럼명) 함수를 사용할 수 있다.
SELECT count(empno)
  FROM emp
 WHERE ename = 'SCOTT';

SELECT 1 AS "존재하니(1:있다, 0:없다)"
  FROM emp
 WHERE ename = 'SCOTT';
 
SELECT * FROM member

SELECT mem_name
FROM
WHERE 아이디 = 값
AND 비번 = 값

-- 아이디와 비번이 일치하는 경우에만 출력 결과를 볼 수 있다.
-- 데이터를 추가한 뒤 commit하지 않으면 실제 DB table에 반영되지 않음
-- 자신 서버를 바라볼때는 결과가 있는 것처럼 보여지지지만 외부에서 접근하면 볼 수 없다.

SELECT mem_name
FROM member
WHERE mem_id =:mid
AND mem_pw =:mpw

