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
-- ���� order by�� ����ϸ� �˻��ӵ��� ������ ���ۿ� ����.

SELECT /*+index_desc(emp PK_EMP) */ empno
FROM emp
-- order by ������� �ʰ� �����ϱ�. �̷��� ����ϴ� ���� �߿�! ���ϴ� ���

CREATE INDEX i_ename
ON emp(ename)

ename �÷��� �����ϸ�(nvl) �ε����� ����� �� ����.
SELECT ename FROM emp
WHERE NVL(ename, '0') = 'XXX'

�ε����� �ִ� �÷��̶� �����ϸ� �ε����� ����� �� ����.

PK�� �ε����� �����Ѵ�. 
FK�� �ε����� �������� �ʴ´�.

SELECT emp.ename, dept.deptno
FROM emp, dept
-- 14*4  �� 56�� > �Ͼ �� �ִ� ��� ����� �� (īŸ�þȰ�)

SELECT emp.ename, dept.deptno
FROM emp, dept
WHERE emp.deptno = dept.deptno
-- �μ���ȣ 10,20,30 �����͸� ��µ� (40�� null���̶� ��� x)
-- �׳� emp���̺��� �����Ϳ� ����

SELECT emp.ename, dept.deptno
FROM emp, dept
WHERE emp.deptno(+) = dept.deptno
-- dept ���̺��� �μ���ȣ 40�� �����Ͱ� �����ϴµ�,
-- emp ���̺��� �μ���ȣ 40���� ���� �����Ͱ� ����
-- but (+) ���� 40���� �ҷ��� �� �ִ�.
 -- Oracle������ ��� ���� ��µǴ� ���̺��� �ݴ��� ���̺��� ���� (+) ��ȣ�� �ٿ� �ۼ����ָ� �ȴ�.

SELECT dept.deptno, dept.dname, count(emp.ename)
FROM emp, dept
WHERE emp.deptno(+) = dept.deptno
GROUP BY dept.deptno, dept.dname

-------------------------------------------------

SELECT DISTINCT(deptno) FROM emp     -- 10,20,30  3�Ǹ� ���

SELECT deptno FROM emp        -- �� 14�� ���

union�� �ߺ��� ����
union all�� �ٸ��� (�ߺ� ���, ������)