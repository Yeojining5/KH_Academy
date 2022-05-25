문제1
영화 티켓을 받을 수 있는 사람의 명단과 현재 가지고 있는 포인트, 
영화 티켓의 포인트 그리고 그 티켓을 사용한 후 남은 예상 포인트를 출력하시오.

SELECT M.name_vc "이름",
       M.point_nu "보유",
       P.point_nu "적용",
       M.point_nu - P.point_nu "남은 예상"
  FROM t_giftmem M,
       (SELECT point_nu
          FROM t_giftpoint
         WHERE name_vc = '영화티켓') P
 WHERE M.point_nu >= 15000;
 
 
SELECT M.name_vc "이름",
       to_char(M.point_nu, '999,999')||'원' "보유",
       to_char(P.point_nu, '999,999')||'원' "적용",
       to_char(M.point_nu - P.point_nu, '999,999')||'원' "남은 예상"
  FROM t_giftmem M,
       (SELECT point_nu
          FROM t_giftpoint
         WHERE name_vc = '영화티켓') P
 WHERE M.point_nu >= 15000;
 
  
___________________________________________________________

문제2
김유신씨가 보유하고 있는 마일리지 포인트로 얻을 수 있는 상품 중
가장 포인트가 높은 것은 무엇인가?


SELECT name_vc, point_nu
  FROM (SELECT name_vc, point_nu
          FROM t_giftpoint
         WHERE point_nu <= 50012
      ORDER BY point_nu desc)
  WHERE ROWNUM = 1;


 