*  �������ڵ� �����ϱ�

���� �ο쿡 �ִ� ������ ������ ������ �����ϴ�

-- A����
SELECT ROWNUM rno, cdate, amt
FROM test02

--B����
SELECT ROWNUM cno, cdate, crate
FROM test02


SELECT A.cdate, A.amt, B.crate, to_char(A.amt*B.crate, '999,999,999')||'��' AS "TOTAL"
FROM (SELECT ROWNUM rno, cdate, amt
         FROM test02) A
    ,(SELECT ROWNUM cno, cdate, crate
        FROM test02) B
WHERE A.rno-1 = B.cno
