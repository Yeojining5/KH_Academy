����1
��ȭ Ƽ���� ���� �� �ִ� ����� ��ܰ� ���� ������ �ִ� ����Ʈ, 
��ȭ Ƽ���� ����Ʈ �׸��� �� Ƽ���� ����� �� ���� ���� ����Ʈ�� ����Ͻÿ�.

SELECT M.name_vc "�̸�",
       M.point_nu "����",
       P.point_nu "����",
       M.point_nu - P.point_nu "���� ����"
  FROM t_giftmem M,
       (SELECT point_nu
          FROM t_giftpoint
         WHERE name_vc = '��ȭƼ��') P
 WHERE M.point_nu >= 15000;
 
 
SELECT M.name_vc "�̸�",
       to_char(M.point_nu, '999,999')||'��' "����",
       to_char(P.point_nu, '999,999')||'��' "����",
       to_char(M.point_nu - P.point_nu, '999,999')||'��' "���� ����"
  FROM t_giftmem M,
       (SELECT point_nu
          FROM t_giftpoint
         WHERE name_vc = '��ȭƼ��') P
 WHERE M.point_nu >= 15000;
 
  
___________________________________________________________

����2
�����ž��� �����ϰ� �ִ� ���ϸ��� ����Ʈ�� ���� �� �ִ� ��ǰ ��
���� ����Ʈ�� ���� ���� �����ΰ�?


SELECT name_vc, point_nu
  FROM (SELECT name_vc, point_nu
          FROM t_giftpoint
         WHERE point_nu <= 50012
      ORDER BY point_nu desc)
  WHERE ROWNUM = 1;


 