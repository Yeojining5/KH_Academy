1.�� �޿��� ������ 18�� ������ Ȧ�� �޿��� ������ 1/18�� ���޵ǰ�, ¦���޿��� ������ 2/18�� ���޵ȴٰ� �������� �� Ȧ�� �ް� ¦�� �޿� ���� �ݾ��� ��Ÿ���ÿ�.
SELECT emp_name, round(salary / 18, 1) AS "����(Ȧ��)", round(salary / 9, 1) AS "����(¦��)", lev
FROM temp;    


2.������ ���� �� �޿��� ����� 10������ ���޵ȴٸ�(¦������ 20����)���� ������ 
��� �ٲ��� �ۼ��� ���ÿ�.
SELECT emp_name, round(salary / 18, 1)+100000 AS "����(Ȧ��+�����)", round(salary / 9, 1)+200000 AS "����(¦��+�����)", lev
FROM temp; 


3.TEMP ���̺��� ��̰� NULL �� �ƴ� ����� ������ �о���ÿ�.
SELECT emp_name
FROM temp
WHERE hobby IS NOT NULL;


4.TEMP ���̺��� ��̰� NULL�� ����� ��� HOBBY�� ���������̶�� ���� ġȯ�Ͽ� �������� �������� �״�� ���� �о���ÿ�.
SELECT emp_name, NVL(hobby,'����') AS HOBBY
FROM temp;



5.TEMP�� �ڷ� �� HOBBY�� ���� NULL�� ����� ����ꡯ���� ġȯ���� �� HOBBY�� ������� ����� ������ �������� ������ �ۼ��Ͻÿ�.
SELECT emp_name, NVL(hobby,'���') AS HOBBY
FROM temp
WHERE hobby IS NULL OR hobby = '���';


6.TEMP�� �ڷ� �� EMP_ID�� EMP_NAME�� ���� �������,���������� ǥ�õǾ� DISPLAY�ǵ��� COLUMN ALLIAS�� �ο��Ͽ� SELECT �Ͻÿ�.
SELECT emp_id ���, emp_name ����
FROM temp;



7.TEMP�� �ڷḦ ���� ��(LEV)�� ASCENDING�ϸ鼭 ��������� �ٽ� ��� ������ 
DESCENDING�ϰ� �ϴ� ORDER BY�ϴ� ������ ����� ���ÿ�.
SELECT *
FROM temp
ORDER BY lev ASC, emp_id desc;