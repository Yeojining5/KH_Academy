1. ����縸 ������ �ϱ�
2. �ѱ۰��縸 ������ �ϱ�
3. ����� �ѱ۰��� ������ ������ �ϱ�
mod�Լ�- Ȧ¦ / �׷���� / �ζ��κ� /UNION ALL


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

1. ����縸 ������ �ϱ�
SELECT NO, eng_words
  FROM (SELECT MOD (seq_vc, 2) NO,
               DECODE (MOD (seq_vc, 2), 1, words_vc) eng_words
          FROM t_letitbe)
 WHERE NO = 1



2. �ѱ۰��縸 ������ �ϱ�
SELECT kor_words
  FROM (SELECT MOD (seq_vc, 2) NO,
               DECODE (MOD (seq_vc, 2), 0, words_vc) kor_words
          FROM t_letitbe)
 WHERE NO = 0



3. ����� �ѱ۰��� ������ ������ �ϱ� 
  SELECT ����
    FROM (SELECT seq_vc, DECODE (MOD (seq_vc, 2), 1, words_vc) AS "����"
            FROM t_letitbe
           WHERE MOD (seq_vc, 2) = 1
          UNION ALL
          SELECT seq_vc, DECODE (MOD (seq_vc, 2), 0, words_vc) AS "����"
            FROM t_letitbe
           WHERE MOD (seq_vc, 2) = 0)
ORDER BY seq_vc
  

----------------------------------------------------

SELECT seq_vc FROM t_letitbe
ORDER BY to_number(seq_vc) desc
-- seq_vc Ÿ���� varchar2 ���ڿ��� �Ǿ��־ ��ȯ�ؾ� ������ ���������� ��

