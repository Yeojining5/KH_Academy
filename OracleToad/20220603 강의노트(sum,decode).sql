
* 20220603 강의노트

[심화문제]

SELECT deptno FROM dept
-- 인덱스 제공

SELECT deptno FROM emp
-- 인덱스가 없어서 테이블을 풀스캔함

SELECT dept.deptno
FROM emp, dept
WHERE emp.deptno = dept.deptno

SELECT dept.dname
FROM emp, dept
WHERE emp.deptno = dept.deptno

--~별로 라는 말은 GROUP by를 떠올리자

SELECT dept.dname
      ,sum(decode(JOB, 'CLERK', sal)) clerk
FROM emp, dept
WHERE emp.deptno = dept.deptno
GROUP BY dept.dname

SELECT deptno
      ,sum(decode(JOB, 'CLERK', sal)) clerk
      ,sum(decode(JOB, 'MANAGER', sal)) manager
      ,sum(decode(JOB, 'CLERK', NULL,'MANAGER', NULL, sal)) manager
      ,sum(sal)
FROM emp
GROUP BY deptno


SELECT dept.dname
      ,sum(decode(JOB, 'CLERK', sal)) clerk
      ,sum(decode(JOB, 'MANAGER', sal)) manager
      ,sum(decode(JOB, 'CLERK', NULL,'MANAGER', NULL, sal))etc
      ,sum(sal) dept_sal
FROM emp, dept
WHERE emp.deptno = dept.deptno
GROUP BY dept.dname


SELECT
        decode(b.rno, '1', A.dname, '총계') "부서명"
       ,sum(clerk)clerk
       ,sum(manager)manager
       ,sum(etc)etc
       ,sum(dept_sal) dept_sal
FROM  (
         SELECT dept.dname
               ,sum(decode(JOB, 'CLERK', sal)) clerk
               ,sum(decode(JOB, 'MANAGER', sal)) manager
               ,sum(decode(JOB, 'CLERK', NULL,'MANAGER', NULL, sal)) etc
               ,sum(sal) dept_sal
          FROM emp, dept
          WHERE emp.deptno = dept.deptno
        GROUP BY dept.dname
        )A,
        (
         SELECT ROWNUM rno FROM dept
         WHERE ROWNUM <3
         )B
GROUP BY decode(b.rno, '1', A.dname, '총계')
ORDER BY "부서명"