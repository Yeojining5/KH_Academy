20220531 ���ǳ�Ʈ

SELECT * FROM lecture

����:�ִ� ���� �ð��� ������ ������ '�Ϲ�'�� ���� ������ �Ѵ�
��� �ؾ� �ϴ°�?

SELECT decode(lec_time, lec_point, '�Ϲ�')
FROM lecture;

-------------------------------------------------
  
����:�ִ簭�ǽð��� ������ ���� ������ ���ڸ� �˰� �ʹ�.
��� �ؾ� �ϴ°�?

SELECT count(lec_id)
FROM lecture
WHERE lec_time = lec_point

SELECT count(decode(lec_time, lec_point, lec_id))
FROM lecture
WHERE lec_time = lec_point

---------------------------------------------------  
  
����: ���� �ð��� ������ ������ '�Ϲ�'�� ���Ϲ��� �� ���ĵ�
�ϰ� ���� ��쿡�� ��� �ؾ� �ϴ°�?

SELECT decode(lec_time, lec_point, '�Ϲ�')
FROM lecture
ORDER BY decode(lec_time, lec_point, '�Ϲ�')

-----------------------------------------------------
 
�ִ� ���� �ð��� ������ ������ '�Ϲ�' �� '����'�� ���Ϲ��� �� 
���ĵ� �ϰ� ���� ��쿡�� ��� �ؾ��ϴ°�?


SELECT sign(5), sign(-600), sign(10-50) FROM dual

SELECT
       lec_id, lec_time, lec_point
       , DECODE(sign(lec_time-lec_point),1,'�������'
                                        ,0,'�Ϲݰ���'
                                        ,-1,'��Ÿ����') AS "��������"
 FROM lecture

-------------------------------------------------------------

����:���� �ð��� ������ �ٸ��� NULL�� ���ϵǴ� ��� 'Ư��'�̶��
���ϵǵ��� �Ϸ��� ��� �ؾ��ϴ°�?

SELECT decode(lec_time, lec_point, '�Ϲ�', 'Ư��')
FROM lecture






SELECT to_char(sysdate, 'DD')
, to_char(sysdate, 'MM')
, to_char(sysdate, 'DAY')
FROM dual

SELECT '31'||'11' FROM dual


______________________________________________________________

�����Ͽ��� �ش� ���ڿ� 01�� �ٿ��� 4�ڸ� ��ȣ�� �����
ȭ���Ͽ��� 11, �����Ͽ��� 21, ����Ͽ��� 31, �ݿ��Ͽ��� 41, �� 51 �� 61
�ٿ��� 4�ڸ� ��ȣ�� ����ٰ� �� ��, ��ȣ�� select�ϴ� sql�� ����� ���ÿ�

SELECT to_char(sysdate,'DD'),
       to_char(sysdate,'DD') || decode(to_char(sysdate,'DAY'), '������', 01, 
                                                               'ȭ����', 11, 
                                                               '������', 21, 
                                                               '�����', 31, 
                                                               '�ݿ���', 41, 
                                                               '�����', 51, 
                                                               '�Ͽ���', 61) ��ȣ
  FROM dual
  
  
  
 -----------------------------------------------------
 
 ��������
 ��� ���̺��� job�� 'CLERK'�� ����� �޿� ��, 'SALESMAN'�� ����� �޿��� ���� ���ϰ�
 ������ job�� ���ؼ��� ��Ÿ�� ������ ���Ͻÿ�.
 
 SELECT * FROM emp
 
 SELECT JOB, sum(sal) 
  FROM emp 
GROUP BY JOB
HAVING JOB = 'CLERK' OR JOB = 'SALESMAN'


SELECT decode(JOB, 'CLERK', sal, NULL)
      ,decode(JOB, 'SALESMAN', sal, NULL)
      ,decode(JOB, 'CLERK',NULL, 'SALESMAN', NULL, sal)
  FROM emp


// ����
SELECT sum(decode(JOB, 'CLERK', sal, NULL)) AS "CLERK_SUM"
      ,sum(decode(JOB, 'SALESMAN', sal, NULL)) AS "SALESMAN_SUM"
      ,sum(decode(JOB, 'CLERK',NULL, 'SALESMAN', NULL, sal)) AS "ETC_SUM"
  FROM emp
  
  --------------------------------------------------
  
  SELECT * FROM member
  ���̵� �? ���̵� �����ϴ�? 
  ȸ������ �� ���̵� �ߺ��˻� �������� �ۼ��غ���.
  
  SELECT count(mem_id)
  FROM member
  WHERE mem_id =:x
  
  SELECT 1 FROM member
  WHERE mem_id = 'apple'
  
����������  where�� �Ʒ� select���� ���Ѵ�.
�ζ��κ��  from�� �Ʒ� select��

SELECT 1
FROM dual
WHERE EXISTS (SELECT MEM_NAME
                FROM MEMBER
               WHERE MEM_ID='apple')
              
SELECT nvl(hobby, '����') FROM temp

SELECT nvl(
            (SELECT 1
              FROM dual
               WHERE EXISTS (SELECT MEM_NAME
                FROM MEMBER
               WHERE MEM_ID='apple')),0)
  FROM dual