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

----------------------------------------������ �� Ǯ��


1) 
t_giftmem - ȸ�� 5��
t_giftitem - ��ǰ 6����

SELECT *
  FROM t_giftmem, t_giftpoint -- 5*6 �� 30���� ���
  
  �� 30���� ����� ������ ������ 2������ �����ؾ� �Ѵ�.
  1. ��ȭƼ��(�ζ��κ�)   AND   2. M.pint_nu >= P.point_nu(������)
 
SELECT point_nu
  FROM t_giftpoint
  WHERE name_vc = '��ȭƼ��'
  -- 1�ﰡ�� ����� ���� �ִٰ� �����Ͽ� ��ȸ�� �� ��
  -- �� ������ �ζ��κ�� �ִ´� - ��Ƽ�������� ���� �ٿ��ֱ� ����
 
 
  
SELECT M.name_vc "�̸�",
       M.point_nu "����",
       P.point_nu "����",
       M.point_nu - P.point_nu "���� ����"
  FROM t_giftmem M, t_giftpoint P 
  
SELECT M.name_vc "�̸�",
       M.point_nu "����",
       P.point_nu "����",
       M.point_nu - P.point_nu "���� ����"
  FROM t_giftmem M,
       (SELECT point_nu
          FROM t_giftpoint
         WHERE name_vc = '��ȭƼ��') P
 WHERE M.point_nu >= P.point_nu;  
 -- >= 15000  �̶�� ������ٴ� ������ ����� ��!!!
 -- �ζ��κ並 ������� �ʴ´ٸ� wherer ����1 and ����2 �̷������� ��

SELECT M.name_vc "�̸�",
       M.point_nu "����",
       P.point_nu "����",
       M.point_nu - P.point_nu "���� ����"
  FROM t_giftmem M, t_giftpoint P
 WHERE M.point_nu >= P.point_nu  
     AND P.name_vc =:x
     -- ����ó�� > ���� x�� UI���� �����´� ******
 
 2)
 where�� �ؿ� ���� > ��������
 
SELECT point_nu FROM t_giftmem WHERE name_vc = '������'
 
-- ������ ġȯ�ϱ�
SELECT point_nu FROM t_giftmem WHERE name_vc =:NAME


SELECT max(point_nu)
  FROM t_giftpoint
 WHERE point_nu <= ( 
                    SELECT point_nu 
                    FROM t_giftmem 
                    WHERE name_vc = '������'
                    )
-- �� sql���� 50,000�� �����
-- �׷��Լ��� �Ϲ��÷��� ���� ����� �� ����.
-- �� select ���� name_vc�� �߰��ϸ� "���� �׷��� �׷� �Լ��� �ƴմϴ�"
-- ������ name_vc �� max min�� ����� �ȵȴ�.


-- �츮�� ã�� ��� �Ѱ���Ʈ 50000 !
SELECT name_vc, point_nu
FROM t_giftpoint
WHERE point_nu = ( �������� - 50,000��µǴ� �긦 �����Ͷ� )

SELECT name_vc, point_nu
FROM t_giftpoint
WHERE point_nu = (
                SELECT max(point_nu)
                  FROM t_giftpoint
                  WHERE point_nu <= ( 
                                    SELECT point_nu 
                                      FROM t_giftmem 
                                      WHERE name_vc = '������'
                                    ) )
 -- ��������                                    
                                    
 -----------------------------------------------
 
 SELECT ename
FROM emp
WHERE ename LIKE 'S%'

SELECT ename
FROM emp
WHERE ename LIKE '%S'

SELECT ename
FROM emp
WHERE ename LIKE '%S%'

SELECT ename, sal
FROM emp
WHERE sal > 1000
AND sal < 3000
-- ���� ����
-- between A and B �� ǥ�� ����

SELECT ename, sal
FROM emp
WHERE sal BETWEEN 1000 AND 3000