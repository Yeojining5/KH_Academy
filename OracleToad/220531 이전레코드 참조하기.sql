*  이전레코드 참조하기

같은 로우에 있는 데이터 끼리만 접근이 가능하다

-- A집합
SELECT ROWNUM rno, cdate, amt
FROM test02

--B집합
SELECT ROWNUM cno, cdate, crate
FROM test02


SELECT A.cdate, A.amt, B.crate, to_char(A.amt*B.crate, '999,999,999')||'원' AS "TOTAL"
FROM (SELECT ROWNUM rno, cdate, amt
         FROM test02) A
    ,(SELECT ROWNUM cno, cdate, crate
        FROM test02) B
WHERE A.rno-1 = B.cno
