/* Formatted on 2022/05/19 ���� 3:27:25 (QP5 v5.215.12089.38647) */
DDL(��ü����) - DBA

DCL(����) - DB���� ���

DML(SELECT, INSERT, DELETE, UPDATE) : ������ ���۾� (�����ڿ��� �ʿ��Ѱ�)

��ȸ�κ� (�Ƿ����� �� �� ����) - �����ȸ, �ֹ���ȸ
�Է�,����,���� (�Ƿ����� ���� ����)

SELECT �÷���1, �÷���2, .. ..
  FROM �����̸� (
SELECT�� - �ζ��κ�)

--SELECT ename, job
  FROM emp

SELECT ename, job, hiredate
  FROM emp

SELECT ename �̸�, job, hiredate
  FROM emp

  ����Ŭ�� ��Ƽ������ LIKE �ϲ� (JAVA�� JVM���� ����)


SELECT ename, job, hiredate, sal, deptno
  FROM emp

 1) �츮 ȸ�翡 �ٹ��ϴ� ��� �߿��� ALLEN����� �޿��� ���ΰ���?
SELECT ename, sal
  FROM emp
   WHERE ename = 'ALLEN';

2) �츮 ȸ�翡 �ٹ��ϴ� ��� �߿��� �޿��� 1000�޷� �̻��� ����� �̸�, �޿��� ���

SELECT ename, sal
  FROM emp
 WHERE sal >= 1000;

where... AND ������ -> ��ȸ����� �پ���

SELECT ename, sal
  FROM emp
 WHERE sal >= 1000 AND deptno = 20;

where ... OR ������ -> �� �� �ϳ��� �����ϸ� �ȴ�

SELECT ename, sal
  FROM emp
 WHERE sal >= 1000 OR deptno = 20;

ALLEN�� �ҹ��ڷ� �ϰų� �Ϻθ� �ҹ��ڷ� �ص� �˻�����X ����ü�� �빮���̹Ƿ�

SELECT sal
  FROM emp
 WHERE ename = 'ALLEN'
 
 
SELECT ename,
       job,
       sal,
       hiredate,
       deptno
  FROM emp