2022602 �ǽ���Ʈ

CREATE VIEW v_emp1(e_no, e_name)
AS SELECT empno, ename
     FROM emp
    WHERE deptno = 10
    
-- ALLEN 
SELECT sal FROM emp WHERE ename = 'ALLEN'

SELECT ename, sal
 FROM emp
 WHERE sal > (
                SELECT sal FROM emp WHERE ename = 'ALLEN'
              )
              
-------------------------------------------

�������� ��������

1.temp���� ������ ���� ���� ������ row�� ã�Ƽ� �� �ݾװ� ������ �ݾ���
�޴� ������ ����� ������ ����Ͻÿ�.

SELECT salary FROM temp ORDER BY salary desc

SELECT emp_id, emp_name, salary
FROM (
     SELECT emp_id, emp_name, salary
       FROM temp
   ORDER BY salary DESC
      )
WHERE ROWNUM = 1
-----

SELECT max(salary) FROM temp

SELECT emp_id, emp_name
FROM temp
WHERE salary = (
                SELECT max(salary) FROM temp
                )


2.temp�� �ڷḦ �̿��Ͽ� salary�� ����� ���ϰ� �̺��� ū �ݾ��� salary��
�޴� ������ ����� ����, ������ �����ֽÿ�.

SELECT emp_id, emp_name, salary
  FROM temp
  WHERE salary > (
               SELECT avg(salary) FROM temp
               )


3.temp�� ���� �� ��õ�� �ٹ��ϴ� ������ ����� ������ �о���� SQL�� ����
������ �̿��� �����ÿ�.

SELECT emp_id, emp_name
FROM temp
WHERE dept_code IN (
                    SELECT dept_code 
                    FROM tdept 
                    WHERE area = '��õ'
                    )
                    

4.tcom�� ���� �ܿ� Ŀ�̼��� �޴� ������ ����� �����Ǿ� �ִ�.
�� ������ ���������� select�Ͽ� �μ� ��Ī���� Ŀ�̼��� �޴�
�ο����� ���� ������ ����� ���ÿ�.

SELECT emp_id FROM tcom

SELECT dept_code
FROM temp
WHERE emp_id IN (
                 SELECT emp_id 
                 FROM tcom 
                 )


SELECT dept_code, count(emp_id)
FROM temp
WHERE emp_id IN (
                 SELECT emp_id 
                 FROM tcom 
                 )
GROUP BY dept_code


-- ����
SELECT dept_name, count(emp_id)
FROM temp, tdept
WHERE emp_id IN (
                 SELECT emp_id 
                 FROM tcom
                 )
 AND TEMP.DEPT_CODE = tdept.dept_code
GROUP BY dept_name      


---------------------------------------------------
* CASE�� ��������

temp�� �ڷḦ salary�� �з��Ͽ� ��޺� �ο����� ����ϴ� sql�� �ۼ� 
3õ���� ���ϴ� D / 3õ �ʰ� 5õ ���ϴ� C / 5õ �ʰ� 7õ ���ϴ� B / 7õ �ʰ��� A 

SELECT 
      count(CASE WHEN salary <= 30000000 THEN 'D'END) AS D
           ,count(CASE WHEN salary BETWEEN 30000001 AND 50000000 THEN 'C'END) AS C
           ,count(CASE WHEN salary BETWEEN 50000001 AND 70000000 THEN 'B'END) AS B
           ,count(CASE WHEN salary > 70000000 THEN 'A'END) AS A     
FROM temp



���̵�� ����� ��ġ�ϸ� 1�� ��ȯ, ����� Ʋ���� 0�� ��ȯ, ���̵� �������� ������ -1��
��ȯ�ϴ� select���� �ۼ��Ͻÿ� (case���� ���)


SELECT
    CASE WHEN mem_id=:ID THEN
      CASE WHEN mem_pw=:pw THEN 1
        ELSE 0
      END
    ELSE -1
    END AS result
  FROM member


SELECT result
 FROM  (
      SELECT
         CASE WHEN mem_id=:ID THEN
           CASE WHEN mem_pw=:pw THEN 1
             ELSE 0
           END
      ELSE -1
      END AS result
  FROM member
  ORDER BY result desc
         )
WHERE ROWNUM = 1 
    
        

 
      
 

                
