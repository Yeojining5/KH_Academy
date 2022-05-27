2022�� 5�� 23�� �����ͺ��̽� ���� �����Դϴ�.
�������� �۾��ð��� ª�� �ɸ��� �ð� ������� 1���� 15������ ������ �Ű� ���

 * ���� �Լ� > RANK / DENSE_RANK / ROW_NUMBER (�������Լ�)
1) RANK() OVER : ���� ������ �����ϸ� �����ϴ� ����ŭ ���� ������ �ǳʶ� 

SELECT WORKCD_VC, 
       TIME_NU, 
       RANK () OVER (ORDER BY TIME_NU ASC) AS "RNK"
  FROM T_WORKTIME




2) DENSE_RANK() OVER : ���� ������ �����ϴ��� ���� ������ �ǳʶ��� �ʰ� �̾ �ű� (������ ������)

SELECT WORKCD_VC, 
       TIME_NU, 
       DENSE_RANK() OVER (ORDER BY TIME_NU ASC) AS RNK
  FROM T_WORKTIME




3) ROW_NUMBER() OVER : ������ ���̶� ���� �ٸ� ���� �ο�

SELECT WORKCD_VC, 
       TIME_NU, 
       ROW_NUMBER() OVER (ORDER BY TIME_NU ASC) RNK
  FROM T_WORKTIME

