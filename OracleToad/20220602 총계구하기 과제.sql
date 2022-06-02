220602 과제

1) 날짜별로 그룹화하여 판매개수, 판매가격 구하기
  SELECT indate_vc, SUM(qty_nu), SUM(qty_nu * price_nu)
    FROM t_orderbasket
GROUP BY indate_vc


2) GROUPING 함수 사용 - ROLLUP과 함께 쓰이면 텍스트 출력 가능
  SELECT indate_vc "판매날짜",
         GROUPING(indate_vc),
         SUM(qty_nu) "판매개수",
         SUM(qty_nu * price_nu) "판매가격"
    FROM t_orderbasket
GROUP BY ROLLUP(indate_vc)
 -- GROUPING(컬럼명) : 총합계 결과는 1출력, 그외는 0출력
 -- ROLLUP(A) : A로 그룹핑 + 총합계

3) GROUPING(indate_vc)의 결과가 0또는 1로 출력이 되므로
   0은 날짜 그대로 출력, 1은 '총계' 텍스트 출력
   
  3-1)
  SELECT  CASE GROUPING(indate_vc) 
             WHEN 1 THEN '총계'
             ELSE indate_vc
             END AS "판매날짜",
         SUM(qty_nu)||'개' "판매개수",
         SUM(qty_nu * price_nu)||'원' "판매가격"
    FROM t_orderbasket
GROUP BY ROLLUP(indate_vc)

 3-2)
  SELECT DECODE(GROUPING(indate_vc),  1, '총계',  0, indate_vc)
            판매날짜,
         SUM(qty_nu)||'개' "판매개수",
         SUM(qty_nu * price_nu)||'원' "판매가격"
    FROM t_orderbasket
GROUP BY ROLLUP (indate_vc)


