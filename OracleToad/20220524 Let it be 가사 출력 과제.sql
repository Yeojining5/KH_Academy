1. 영어가사만 나오게 하기
2. 한글가사만 나오게 하기
3. 영어가사 한글가사 번갈아 나오게 하기
mod함수- 홀짝 / 그룹바이 / 인라인뷰 /UNION ALL


SELECT * FROM t_letitbe

SELECT decode(mod(seq_vc,2),1,words_vc) eng_words
FROM t_letitbe

SELECT decode(mod(seq_vc,2),0,words_vc) kor_words
FROM t_letitbe

SELECT decode(mod(seq_vc,2),1,words_vc) eng_words
FROM t_letitbe
UNION ALL
SELECT decode(mod(seq_vc,2),0,words_vc) kor_words
FROM t_letitbe


SELECT mod(seq_vc,2) NO,
       decode(mod(seq_vc,2),1,words_vc) eng_words
FROM t_letitbe
WHERE mod(seq_vc,2)=1    

--------------------------------------------------------

1. 영어가사만 나오게 하기
SELECT NO, eng_words
  FROM (SELECT MOD (seq_vc, 2) NO,
               DECODE (MOD (seq_vc, 2), 1, words_vc) eng_words
          FROM t_letitbe)
 WHERE NO = 1



2. 한글가사만 나오게 하기
SELECT kor_words
  FROM (SELECT MOD (seq_vc, 2) NO,
               DECODE (MOD (seq_vc, 2), 0, words_vc) kor_words
          FROM t_letitbe)
 WHERE NO = 0



3. 영어가사 한글가사 번갈아 나오게 하기 
  SELECT 가사
    FROM (SELECT seq_vc, DECODE (MOD (seq_vc, 2), 1, words_vc) AS "가사"
            FROM t_letitbe
           WHERE MOD (seq_vc, 2) = 1
          UNION ALL
          SELECT seq_vc, DECODE (MOD (seq_vc, 2), 0, words_vc) AS "가사"
            FROM t_letitbe
           WHERE MOD (seq_vc, 2) = 0)
ORDER BY seq_vc
  

----------------------------------------------------

SELECT seq_vc FROM t_letitbe
ORDER BY to_number(seq_vc) desc
-- seq_vc 타입이 varchar2 문자열로 되어있어서 전환해야 정렬이 정상적으로 됨

