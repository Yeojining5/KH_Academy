* 220607 �ǽ���Ʈ

EQUAL JOIN
: Equal(=) �������� join�ϴ� ���

[����]
temp���� ���, ����, �μ��ڵ带 �о�µ� �μ���Ī�� �Բ� ���� ���� ���

SELECT T.emp_id, T.emp_name, d.dept_name
FROM temp T,
     tdept d
WHERE T.dept_code = d.dept_code
--- �������� ���



SELECT T.emp_id, T.emp_name, d.dept_name
  FROM temp T JOIN tdept d
    ON T.dept_code = d.dept_code
-- �ֱ� ����


SELECT emp_id, emp_name, dept_name
FROM temp NATURAL JOIN tdept
-- NATURAL JOIN  -- �ĺ��ڸ� �������x (�����ڵ��� ��ȣ������x)


-- INNER JOIN ������ �����ϴ� �ุ ���� ����� �����´�.


��������
tcom��  work_year�� 2001�� �ڷ�� temp�� ������� �����ؼ� ������ ��
comm�� �޴� ������ ����, salary+com�� ��ȸ�ϴ� sql���� �ۼ��Ͻÿ�.

SELECT A.work_year, B.emp_name, (B.salary + A.comm) total
  FROM tcom A, 
       temp B
 WHERE A.work_year = 2001
   AND A.emp_id = B.emp_id
   
   -------------------------------------------------------
   
 NON-EQUAL ����
 : ���� ������ =�� �ƴ� �ٸ� �����ȣ�� �־����� ��� (BETWEEN, >, >=, <, <=)
 
temp�� emp_level�� �̿��� emp_level�� ���� ������ 
���� ����/���� ���� ���� ��� ������ ����� ����, ����, salary�� �о���� sql�� �ۼ�

SELECT A.emp_id, A.emp_name, A.lev, A.salary
  FROM temp A,
       emp_level B
 WHERE A.salary BETWEEN from_sal AND to_sal
  AND B.lev = '����'
  
  -----------------------------------------------
  
  OUTER JOIN
  : �� �� �̻��� ���̺� ���ν� ���� ���̺��� �࿡ ���� �ٸ��� ���̺� ��ġ�ϴ� ���� ������
   �ٸ��� ���̺��� ���� null�� �Ͽ� ���� RETURN �ϴ� ���� OUTER join�̴�.
   Oracle������ ��� ���� ��µǴ� ���̺��� �ݴ��� ���̺� ���� (+) ��ȣ�� �ٿ��ָ� ���� ���(WHERE ��)
  
�� ����� ����, salary, ���� ���ѱݾ�, ���� ���ѱݾ��� ������ �Ѵ�.
temp�� emp_level�� �����Ͽ� ����� �����ֵ�, ������ �������� ��ϵǾ� ���� ����
���� ����� ����, salary ������ �̶� ���� �� �ֵ��� ������ �ۼ�

SELECT A.lev, A.emp_name, A.salary, B.from_sal, B.to_sal
  FROM temp A LEFT OUTER JOIN emp_level B
    ON A.lev = B.lev
    
SELECT A.lev, A.emp_name, A.salary, B.from_sal, B.to_sal
  FROM temp A,
       emp_level B
WHERE A.lev = B.lev(+)

----------------------------------------------

self JOIN


tdept ���̺� �ڽ��� ���� �μ������� �����ϰ� �ִ�
�� ���̺��� �̿��Ͽ� �μ��ڵ�, �μ���, �����μ��ڵ�, �����μ����� �о���� ���� �ۼ�

SELECT 
        A.dept_code AS "�μ��ڵ�",
        A.dept_name AS "�μ���",
        b.dept_code AS "�����μ��ڵ�",
        b.dept_name AS "�����μ���"
   FROM tdept A, tdept b
   WHERE b.dept_code = A.parent_dept

  
