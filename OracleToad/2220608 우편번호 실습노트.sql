* 2220608 우편번호 실습노트

SELECT count(*) AS "우편번호 전체 조회수" FROM zipcode_t
-- 총 51504건

--우리집 주소 찾아보기
SELECT *
FROM zipcode_t
WHERE dong LIKE '%대신%'
  AND ri LIKE '%보통%'
  
SELECT *
  FROM zipcode_t 
 WHERE dong LIKE '%분당%'
 

SELECT address, zipcode
FROM zipcode_t
WHERE dong LIKE '%당산%'

SELECT DISTINCT zdo, sigu
FROM zipcode_t
ORDER BY zdo

SELECT DISTINCT zdo
FROM zipcode_t
ORDER BY zdo

UPDATE zipcode_t set zdo = '경남' WHERE zdo = '경??의령군'

COMMIT;



SELECT DISTINCT sigu
FROM zipcode_t
WHERE zdo = '서울'
ORDER BY sigu



SELECT '전체' zdo FROM dual
UNION ALL
SELECT 
       DISTINCT(zdo) zdo
  FROM zipcode_t
ORDER BY zdo ASC

--------------------------------------

-- 전체 포함 모든 시 출력
SELECT '전체' zdo FROM dual
UNION ALL
SELECT zdo
  FROM (
        SELECT 
              DISTINCT(zdo) zdo
      FROM zipcode_t
      ORDER BY zdo ASC
      )
 

-- 전체 포함 시,도의 구 출력 (사용자가 선택한 값에따라 바뀌도록 변수 사용)  
SELECT '전체' sigu FROM dual
UNION ALL
SELECT sigu
  FROM (
        SELECT DISTINCT(sigu) sigu
FROM zipcode_t
WHERE zdo =:userDo
ORDER BY sigu
      )


-- 전체 포함 해당 구의 동 출력
SELECT '전체' dong FROM dual
UNION ALL
SELECT dong
  FROM (
        SELECT DISTINCT(dong) dong
FROM zipcode_t
WHERE sigu =: userGu
ORDER BY dong
      )