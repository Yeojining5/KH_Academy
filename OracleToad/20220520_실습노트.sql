SELECT deptno, dname, loc FROM dept

SELECT empno, ename, JOB, mgr, hiredate, comm, sal, deptno FROM emp

-- ���̺� ����� ���� �����ϱ�
���Ἲ ��������(FK_DEPTNO) ������ ������ �Ұ��ϴ�.
������� ������ �Ұ��ϴ� = �����͸� �����ϰ� ���� ����
�ε����� �����ȴ� (����, �˻��ӵ� ����)

DELETE FROM dept

DELETE FROM emp

ROLLBACK

dept���̺��� deptno�� pk�̰� - �⺻Ű
emp���̺��� deptno�� fk�̴� - �ܷ�Ű

SELECT empno
  FROM emp
 WHERE ename = 'SCOTT';

�Լ���(�÷���) �Լ��� ����� �� �ִ�.
SELECT count(empno)
  FROM emp
 WHERE ename = 'SCOTT';

SELECT 1 AS "�����ϴ�(1:�ִ�, 0:����)"
  FROM emp
 WHERE ename = 'SCOTT';
 
SELECT * FROM member

SELECT mem_name
FROM
WHERE ���̵� = ��
AND ��� = ��

-- ���̵�� ����� ��ġ�ϴ� ��쿡�� ��� ����� �� �� �ִ�.
-- �����͸� �߰��� �� commit���� ������ ���� DB table�� �ݿ����� ����
-- �ڽ� ������ �ٶ󺼶��� ����� �ִ� ��ó�� ������������ �ܺο��� �����ϸ� �� �� ����.

SELECT mem_name
FROM member
WHERE mem_id =:mid
AND mem_pw =:mpw

