** 220603 ����

1) �ζ��κ�� ����� �������̺� ����..
   4�г���� �����Ƿ� 4���� ��µǵ��� 5�̸����� ������ �ش�

SELECT ROWNUM NO
  FROM dept
 WHERE ROWNUM < 5


  
2) test11 ���̺�(12��)�� �������̺�(4��)�� 
   Cartesian Product�� �����Ѽ� �� 48���� �����

SELECT NO, coll, dept, fre
FROM test11,
     (
        SELECT ROWNUM NO
        FROM dept
        WHERE ROWNUM < 5
     )A



3) rownum�� 4������ �����Ƿ� 1���� �� 1�г�, 2���� �� 2�г�, .. 
   �̷������� ������ �� �� �ִٴ� ���� Ȯ���� �� �����Ƿ�
   decode�� Ȱ���Ѵ�.

SELECT NO, coll, dept,
       decode(NO,1,fre,2,sup,3,jun,4,sen)
FROM test11,
     (
        SELECT ROWNUM NO
        FROM dept
        WHERE ROWNUM < 5
     )A
  
   

4)  dept�� ������ ������ ���ĵǾ� �����Ƿ�
    ORDER BY�� dept�� �������� ������ �����Ѵ�.

SELECT NO, coll, dept,
       decode(NO,1,fre,2,sup,3,jun,4,sen)
FROM test11,
     (
        SELECT ROWNUM NO
        FROM dept
        WHERE ROWNUM < 5
     )A    
ORDER BY dept


5) ���������� ALIAS ��� �Բ� 1~4�г��� �ο����� 
   �� �྿ ��µ� �� �ֵ��� ������.

SELECT coll, dept,
       decode(NO,1,'1�г�',2,'2�г�',3,'3�г�',4,'4�г�') AS "KEY3",
       decode(NO,1,fre,2,sup,3,jun,4,sen) AS "KEY4"
FROM test11,
     (
        SELECT ROWNUM NO
        FROM dept
        WHERE ROWNUM < 5
     )
ORDER BY dept


6) KEY3 �� �г��� 1-2-3-4�г� ������� ��µ� �� �ֵ���
   ORDER BY ���Ŀ� KEY3�� dept �������� ������ ���ĵ� �� �ֵ��� �Ѵ�.

SELECT coll, dept,
       decode(NO,1,'1�г�',2,'2�г�',3,'3�г�',4,'4�г�') AS "KEY3",
       decode(NO,1,fre,2,sup,3,jun,4,sen) AS "KEY4"
FROM test11,
     (
        SELECT ROWNUM NO
        FROM dept
        WHERE ROWNUM < 5
     )
ORDER BY dept ASC, key3 ASC
