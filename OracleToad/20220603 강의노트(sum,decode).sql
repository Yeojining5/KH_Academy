
* 20220603 ���ǳ�Ʈ

[��ȭ����]

SELECT deptno FROM dept
-- �ε��� ����

SELECT deptno FROM emp
-- �ε����� ��� ���̺��� Ǯ��ĵ��

SELECT dept.deptno
FROM emp, dept
WHERE emp.deptno = dept.deptno

SELECT dept.dname
FROM emp, dept
WHERE emp.deptno = dept.deptno

--~���� ��� ���� GROUP by�� ���ø���

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
        decode(b.rno, '1', A.dname, '�Ѱ�') "�μ���"
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
GROUP BY decode(b.rno, '1', A.dname, '�Ѱ�')
ORDER BY "�μ���"