1.월 급여는 연봉을 18로 나누어 홀수 달에는 연봉의 1/18이 지급되고, 짝수달에는 연봉의 2/18가 지급된다고 가정했을 때 홀수 달과 짝수 달에 받을 금액을 나타내시오.
SELECT emp_name, round(salary / 18, 1) AS "월급(홀수)", round(salary / 9, 1) AS "월급(짝수)", lev
FROM temp;    


2.위에서 구한 월 급여에 교통비가 10만원씩 지급된다면(짝수달은 20만원)위의 문장이 
어떻게 바뀔지 작성해 보시오.
SELECT emp_name, round(salary / 18, 1)+100000 AS "월급(홀수+교통비)", round(salary / 9, 1)+200000 AS "월급(짝수+교통비)", lev
FROM temp; 


3.TEMP 테이블에서 취미가 NULL 이 아닌 사람의 성명을 읽어오시오.
SELECT emp_name
FROM temp
WHERE hobby IS NOT NULL;


4.TEMP 테이블에서 취미가 NULL인 사람은 모두 HOBBY를 “없음”이라고 값을 치환하여 가져오고 나머지는 그대로 값을 읽어오시오.
SELECT emp_name, NVL(hobby,'없음') AS HOBBY
FROM temp;



5.TEMP의 자료 중 HOBBY의 값이 NULL인 사원을 ‘등산’으로 치환했을 때 HOBBY가 ‘등산인 사람의 성명을 가져오는 문장을 작성하시오.
SELECT emp_name, NVL(hobby,'등산') AS HOBBY
FROM temp
WHERE hobby IS NULL OR hobby = '등산';


6.TEMP의 자료 중 EMP_ID와 EMP_NAME을 각각 ‘사번’,’성명’으로 표시되어 DISPLAY되도록 COLUMN ALLIAS를 부여하여 SELECT 하시오.
SELECT emp_id 사번, emp_name 성명
FROM temp;



7.TEMP의 자료를 직급 명(LEV)에 ASCENDING하면서 결과내에서 다시 사번 순으로 
DESCENDING하게 하는 ORDER BY하는 문장을 만들어 보시오.
SELECT *
FROM temp
ORDER BY lev ASC, emp_id desc;