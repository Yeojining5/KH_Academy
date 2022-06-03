* 20220531 컬럼을 로우로 과제

1) 인라인뷰에 들어갈 쿼리문 작성
SELECT ROWNUM NO, emp_id, emp_name 
  FROM temp


2) ROWNUM RNO를 5로 나누고 CEIL로 올림하여 1열당 5명씩 총 4열 출력
SELECT CEIL(NO/5) CNO, emp_id, emp_name 
  FROM (
        SELECT ROWNUM NO, emp_id, emp_name 
          FROM temp
       )

      
3) MOD 함수 이용하여 컬럼 번호로 쓸 데이터 추가
SELECT CEIL(NO/5) CNO
      ,MOD(NO,5) MNO
      ,emp_id
      ,emp_name 
FROM (
      SELECT ROWNUM NO, emp_id, emp_name 
        FROM temp
       )


4) 다른 행으로 분산시키기
SELECT CEIL(NO/5) CNO
      ,MOD(NO,5) MNO      
      ,DECODE(MOD(NO,5),1,emp_name) NAME1
      ,DECODE(MOD(NO,5),2,emp_name) NAME2
      ,DECODE(MOD(NO,5),3,emp_name) NAME3
      ,DECODE(MOD(NO,5),4,emp_name) NAME4
      ,DECODE(MOD(NO,5),0,emp_name) NAME5
      ,emp_id
      ,emp_name 
FROM (
      SELECT ROWNUM NO, emp_id, emp_name 
        FROM temp
       )
  
     
5)
SELECT
      CEIL(NO/5) CNO 
      ,max(DECODE(MNO,1,emp_id)) ID1
      ,max(DECODE(MNO,1,emp_name)) NAME1
      ,max(DECODE(MNO,2,emp_id)) ID2
      ,max(DECODE(MNO,2,emp_name)) NAME2
      ,max(DECODE(MNO,3,emp_id)) ID3
      ,max(DECODE(MNO,3,emp_name)) NAME3
      ,max(DECODE(MNO,4,emp_id)) ID4
      ,max(DECODE(MNO,4,emp_name)) NAME4
      ,max(DECODE(MNO,0,emp_id)) ID5
      ,max(DECODE(MNO,0,emp_name)) NAME5
FROM (
      SELECT ROWNUM NO, CEIL(ROWNUM/5) CNO, MOD(ROWNUM,5) MNO, emp_id, emp_name 
        FROM temp
       )
GROUP BY CEIL(NO/5)

---------------------------------------------------


