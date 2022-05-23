2022년 5월 23일 데이터베이스 구현 과제입니다.
데이터의 작업시간이 짧게 걸리는 시간 순서대로 1부터 15까지의 순위를 매겨 출력

 * 순위 함수 > RANK / DENSE_RANK / ROW_NUMBER (윈도우함수)
1) RANK() OVER : 같은 순위가 존재하면 존재하는 수만큼 다음 순위를 건너뜀 

SELECT WORKCD_VC, 
       TIME_NU, 
       RANK () OVER (ORDER BY TIME_NU ASC) AS "RNK"
  FROM T_WORKTIME




2) DENSE_RANK() OVER : 같은 순위가 존재하더라도 다음 순위를 건너뛰지 않고 이어서 매김 (순위가 밀집됨)

SELECT WORKCD_VC, 
       TIME_NU, 
       DENSE_RANK() OVER (ORDER BY TIME_NU ASC) AS RNK
  FROM T_WORKTIME




3) ROW_NUMBER() OVER : 동일한 값이라도 각기 다른 순위 부여

SELECT WORKCD_VC, 
       TIME_NU, 
       ROW_NUMBER() OVER (ORDER BY TIME_NU ASC) RNK
  FROM T_WORKTIME

