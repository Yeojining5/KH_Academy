1.�� �޿��� ������ 18�� ������ Ȧ�� �޿��� ������ 1/18�� ���޵ǰ�, ¦���޿��� ������ 2/18�� ���޵ȴٰ� �������� �� Ȧ�� �ް� ¦�� �޿� ���� �ݾ��� ��Ÿ���ÿ�.
SELECT emp_name,
       ROUND (salary / 18, 1) "����(Ȧ��)",
       ROUND (salary / 9, 1) "����(¦��)",
       lev
  FROM temp;  
-----------------------------------���� ��Ǯ��
SELECT emp_name,
       salary,
       to_char(round(salary / 18, -1), '999,999,999')||'��' "Ȧ���� �޿�",
       to_char(round(salary / 9, -1),'999,999,999')||'��' "¦���� �޿�"
  FROM temp

* �������� ���������� ��ȯ���ִ� �Լ� > To_CHAR
to_char(��¥, 'yyyymmdd')
to_char(500000,'999,999,999')
SELECT 550000, to_char(550000, '999,999'), to_char(55000000, '999,999,999')
FROM dual

SELECT ROUND (1234567.456, 1),    // 1234567.5
       ROUND (1234567.456, -1),   // 1234570
       ROUND (1234567.456, 2)     // 1234567.46
  FROM DUAL


2.������ ���� �� �޿��� ����� 10������ ���޵ȴٸ�(¦������ 20����)���� ������ 
��� �ٲ��� �ۼ��� ���ÿ�.
SELECT emp_name,
       ROUND (salary / 18, 1) + 100000 AS "����(Ȧ��+�����)",
       ROUND (salary / 9, 1) + 200000 AS "����(¦��+�����)",
       lev
  FROM temp;
  -------------------------------------
  SELECT emp_name,
       salary,
       to_char(round(salary / 18, -1)+100000, '999,999,999')||'��' "Ȧ���� �޿�",
       to_char(round(salary / 9, -1)+200000,'999,999,999')||'��' "¦���� �޿�"
  FROM temp


3.TEMP ���̺��� ��̰� NULL �� �ƴ� ����� ������ �о���ÿ�.
SELECT emp_name
  FROM temp
 WHERE hobby IS NOT NULL;
------------------------------------------
null�� �𸥴�, �������� �ʾҴ�, �׷��� �������� �ƴϴ�

emp ���̺���, ��� �߿��� �μ�Ƽ�긦 �޴� ����� �̸�, �μ�Ƽ����� ���
SELECT ename, comm
FROM emp
WHERE comm IS NOT NULL

SELECT ename, comm
FROM emp
WHERE comm <> 0

SELECT ename, comm
FROM emp
WHERE comm > 0

SELECT ename, sal FROM emp

��� �߿��� �μ���ȣ�� 10 OR 30�� ����� �̸��� �μ���ȣ ���
  SELECT ename, deptno
    FROM emp
   WHERE deptno = 10 OR deptno = 30    >> ������, ��������
ORDER BY deptno

  SELECT ename, deptno
    FROM emp
   WHERE deptno IN (10, 30)    >> �����ڵ� ���̿��� �� �Ϲ����� ����

  SELECT ename, deptno
    FROM emp
   WHERE deptno = 10
   UNION ALL
     SELECT ename, deptno
    FROM emp
   WHERE deptno = 30


4.TEMP ���̺��� ��̰� NULL�� ����� ��� HOBBY�� ���������̶�� ���� ġȯ�Ͽ� �������� �������� �״�� ���� �о���ÿ�.
SELECT emp_name, NVL (hobby, '����') AS HOBBY 
  FROM temp;
-- NVL �Լ��� ���� ���̺� ���� �ݿ��ϴ� ���� �ƴϴ�. Null�� üũ��


5.TEMP�� �ڷ� �� HOBBY�� ���� NULL�� ����� ����ꡯ���� ġȯ���� �� HOBBY�� ������� ����� ������ �������� ������ �ۼ��Ͻÿ�.
SELECT emp_name, NVL (hobby, '���') AS HOBBY
  FROM temp
 WHERE hobby IS NULL OR hobby = '���';


6.TEMP�� �ڷ� �� EMP_ID�� EMP_NAME�� ���� �������,���������� ǥ�õǾ� DISPLAY�ǵ��� COLUMN ALLIAS�� �ο��Ͽ� SELECT �Ͻÿ�.
SELECT emp_id ���, emp_name ���� 
  FROM temp;



7.TEMP�� �ڷḦ ���� ��(LEV)�� ASCENDING�ϸ鼭 ��������� �ٽ� ��� ������ 
DESCENDING�ϰ� �ϴ� ORDER BY�ϴ� ������ ����� ���ÿ�.
  SELECT *
    FROM temp
ORDER BY lev ASC, emp_id DESC;