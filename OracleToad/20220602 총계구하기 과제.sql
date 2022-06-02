220602 ����

1) ��¥���� �׷�ȭ�Ͽ� �ǸŰ���, �ǸŰ��� ���ϱ�
  SELECT indate_vc, SUM(qty_nu), SUM(qty_nu * price_nu)
    FROM t_orderbasket
GROUP BY indate_vc


2) GROUPING �Լ� ��� - ROLLUP�� �Բ� ���̸� �ؽ�Ʈ ��� ����
  SELECT indate_vc "�Ǹų�¥",
         GROUPING(indate_vc),
         SUM(qty_nu) "�ǸŰ���",
         SUM(qty_nu * price_nu) "�ǸŰ���"
    FROM t_orderbasket
GROUP BY ROLLUP(indate_vc)
 -- GROUPING(�÷���) : ���հ� ����� 1���, �׿ܴ� 0���
 -- ROLLUP(A) : A�� �׷��� + ���հ�

3) GROUPING(indate_vc)�� ����� 0�Ǵ� 1�� ����� �ǹǷ�
   0�� ��¥ �״�� ���, 1�� '�Ѱ�' �ؽ�Ʈ ���
   
  3-1)
  SELECT  CASE GROUPING(indate_vc) 
             WHEN 1 THEN '�Ѱ�'
             ELSE indate_vc
             END AS "�Ǹų�¥",
         SUM(qty_nu)||'��' "�ǸŰ���",
         SUM(qty_nu * price_nu)||'��' "�ǸŰ���"
    FROM t_orderbasket
GROUP BY ROLLUP(indate_vc)

 3-2)
  SELECT DECODE(GROUPING(indate_vc),  1, '�Ѱ�',  0, indate_vc)
            �Ǹų�¥,
         SUM(qty_nu)||'��' "�ǸŰ���",
         SUM(qty_nu * price_nu)||'��' "�ǸŰ���"
    FROM t_orderbasket
GROUP BY ROLLUP (indate_vc)


