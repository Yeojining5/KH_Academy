�츮ȸ�翡 �ٹ��ϴ� ������� �޿� �Ѿ��� ��?

SELECT sum(sal) FROM emp

SELECT 
       SUM(DECODE (JOB, 'CLERK', sal)) AS "clerk_sum",
       sum(DECODE (JOB, 'SALESMAN', sal)) AS "salesman_sum",
       sum(DECODE (JOB,  'CLERK', NULL,  'SALESMAN', NULL,  sal)) AS "etc_sum"
  FROM emp
  

<����>
SELECT EMPNO FROM EMP
ORDER BY EMPNO DESC

SELECT EMPNO FROM EMP
ORDER BY EMPNO ASC
  
SELECT empno FROM emp
�� ������ �ε����� ���Ͽ� �ڵ� ������ ���ĵǾ� ���� 

ORDER by�� �ϸ� ��ĵ�� ��� ������� ���ϰ�
2�� ������ �ؾ߸� �Ѵ� = ������

ORDER by�� ���� �ʰ� ������ �� �� �ִٸ�  nic > index�� �ʿ伺 


SELECT 
        /*+ index+desc(emp pk_emp) */ empno
  FROM emp
�� SQL���� �������Ͽ� Ctrl + E �ϸ� �ε��� Ȯ�� ����
hint���� ����Ͽ� ��Ƽ���������� ������ ������ ������ �� �ִ�.
���� ��Ÿ�� ������ ���õȴ�.

SELECT ename FROM emp

-- ���̺��� pk�� �ε����� ������
-- �ε����� �ִ� �÷��� ���̺� access ���� ��°�����
   [describe] - [Script] ������ Ȯ�� ����
--- index�� �����ϴ� �÷��� ���̺� �׼��� ���� ����� ������
   ORDER BY ���� ������ �� �ִٸ� �˻� �ӵ��� ���� �� �ִ�.
   
SELECT rowid rid FROM emp   

SELECT ename, deptno, JOB FROM emp
WHERE rowid = 'AAARE8AAEAAAACTAAD'
 �� SQL ������ ����Ŭ���� �����ϴ� ID
 
DBMS�� ������ �ִ� ��� �������� ������ ������ �ĺ���
index���̺��� INDEX KEY �� rowid�� ������
������ �������� ������ INDEX ���̺� ���� �ִ� rowid(18�ڸ�)��
�ش� �����͸� ã�� ���� �ϳ��� ������ �����̴�.
1) 6�ڸ� : ������ ������Ʈ ��ȣ
2) 3�ڸ� : ������� ���� ��ȣ
3) 6�ڸ� : ��Ϲ�ȣ
4) 3�ڸ� : ��� ���� �� ��ȣ

<ROWNUM>  ���������� ��ȣ ���
SELECT ROWNUM, empno FROM emp
WHERE deptno = 30


<GROUP BY ��>
�츮 ȸ�翡 �ٹ��ϴ� ����鿡 ���ؼ� �μ��� ��� ���� ���
������� - FK = deptno (�μ������� pk�� ������)
 -- pk�� �ߺ��� ����ȴ�.
 -- �ε����� �������� �ʴ´�.
 -- FK�� �����̼��̴�. (1:n ��������)

SELECT deptno, count(empno)
FROM emp
GROUP BY deptno

�׷��Լ� - avg, count, max, min, sum
: ���̺� ��ü �����Ϳ��� ������� ����� ��� ���ؼ� �� ���տ� �����Ͽ� �ϳ��� ����� ������

SELECT sum(sal), max(ename) FROM emp
�� ���忡�� ename�� �׳� �Ϲ��÷����� �� �� �����Ƿ� �׷��Լ��� ����� (��ü������ ��ǥ�ϴ� ��� �̸��� ���� ����)
** �� �ٸ� ����� GROUP BY ���� ��� �ϴ� ��

SELECT sum(sal), deptno FROM emp
GROUP BY deptno
-- group by�� ����� �÷����� select ������ ������� �� �ǹ̰� �ִ�. ��������

SELECT max(sal), avg(sal), count(JOB), JOB FROM emp
GROUP BY JOB


SELECT M.empno, M.ename, M.JOB, M.deptno,
      (SELECT T.dname FROM dept T WHERE M.deptno = T.deptno) AS dname
FROM emp M;
-- ��Į�� ��������(Scalar Subquery)�� �̿��Ͽ� emp���̺� �������� �ʴ� dname�� dept���̺��� ������
-- select ���� ��ġ (�÷��� �� �� �ִ� �ڸ�)
-- ȥ�� �����غ� ��