* 20220531 �÷��� �ο�� ����

1) �ζ��κ信 �� ������ �ۼ�
SELECT ROWNUM NO, emp_id, emp_name 
  FROM temp


2) ROWNUM RNO�� 5�� ������ CEIL�� �ø��Ͽ� 1���� 5�� �� 4�� ���
SELECT CEIL(NO/5) CNO, emp_id, emp_name 
  FROM (
        SELECT ROWNUM NO, emp_id, emp_name 
          FROM temp
       )

      
3) MOD �Լ� �̿��Ͽ� �÷� ��ȣ�� �� ������ �߰�
SELECT CEIL(NO/5) CNO
      ,MOD(NO,5) MNO
      ,emp_id
      ,emp_name 
FROM (
      SELECT ROWNUM NO, emp_id, emp_name 
        FROM temp
       )


4) �ٸ� ������ �л��Ű��
SELECT CEIL(NO/5) CNO
      ,MOD(NO,5) MNO      
      ,DECODE(MOD(NO,5),1,emp_name) NAME1
      ,DECODE(MOD(NO,5),2,emp_name) NAME2
      ,DECODE(MOD(NO,5),3,emp_name) NAME3
      ,DECODE(MOD(NO,5),4,emp_name) NAME4
      ,DECODE(MOD(NO,5),0,emp_name) NAME5
      ,emp_id
      ,emp_name 
FROM (
      SELECT ROWNUM NO, emp_id, emp_name 
        FROM temp
       )
  
     
5)
SELECT
      CEIL(NO/5) CNO 
      ,max(DECODE(MNO,1,emp_id)) ID1
      ,max(DECODE(MNO,1,emp_name)) NAME1
      ,max(DECODE(MNO,2,emp_id)) ID2
      ,max(DECODE(MNO,2,emp_name)) NAME2
      ,max(DECODE(MNO,3,emp_id)) ID3
      ,max(DECODE(MNO,3,emp_name)) NAME3
      ,max(DECODE(MNO,4,emp_id)) ID4
      ,max(DECODE(MNO,4,emp_name)) NAME4
      ,max(DECODE(MNO,0,emp_id)) ID5
      ,max(DECODE(MNO,0,emp_name)) NAME5
FROM (
      SELECT ROWNUM NO, CEIL(ROWNUM/5) CNO, MOD(ROWNUM,5) MNO, emp_id, emp_name 
        FROM temp
       )
GROUP BY CEIL(NO/5)

---------------------------------------------------


