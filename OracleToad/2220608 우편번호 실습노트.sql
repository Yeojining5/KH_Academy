* 2220608 �����ȣ �ǽ���Ʈ

SELECT count(*) AS "�����ȣ ��ü ��ȸ��" FROM zipcode_t
-- �� 51504��

--�츮�� �ּ� ã�ƺ���
SELECT *
FROM zipcode_t
WHERE dong LIKE '%���%'
  AND ri LIKE '%����%'
  
SELECT *
  FROM zipcode_t 
 WHERE dong LIKE '%�д�%'
 

SELECT address, zipcode
FROM zipcode_t
WHERE dong LIKE '%���%'

SELECT DISTINCT zdo, sigu
FROM zipcode_t
ORDER BY zdo

SELECT DISTINCT zdo
FROM zipcode_t
ORDER BY zdo

UPDATE zipcode_t set zdo = '�泲' WHERE zdo = '��??�Ƿɱ�'

COMMIT;



SELECT DISTINCT sigu
FROM zipcode_t
WHERE zdo = '����'
ORDER BY sigu



SELECT '��ü' zdo FROM dual
UNION ALL
SELECT 
       DISTINCT(zdo) zdo
  FROM zipcode_t
ORDER BY zdo ASC

--------------------------------------

-- ��ü ���� ��� �� ���
SELECT '��ü' zdo FROM dual
UNION ALL
SELECT zdo
  FROM (
        SELECT 
              DISTINCT(zdo) zdo
      FROM zipcode_t
      ORDER BY zdo ASC
      )
 

-- ��ü ���� ��,���� �� ��� (����ڰ� ������ �������� �ٲ�� ���� ���)  
SELECT '��ü' sigu FROM dual
UNION ALL
SELECT sigu
  FROM (
        SELECT DISTINCT(sigu) sigu
FROM zipcode_t
WHERE zdo =:userDo
ORDER BY sigu
      )


-- ��ü ���� �ش� ���� �� ���
SELECT '��ü' dong FROM dual
UNION ALL
SELECT dong
  FROM (
        SELECT DISTINCT(dong) dong
FROM zipcode_t
WHERE sigu =: userGu
ORDER BY dong
      )