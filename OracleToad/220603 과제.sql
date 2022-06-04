** 220603 과제

1) 인라인뷰로 사용할 더미테이블 생성..
   4학년까지 있으므로 4행이 출력되도록 5미만으로 조건을 준다

SELECT ROWNUM NO
  FROM dept
 WHERE ROWNUM < 5


  
2) test11 테이블(12행)과 더미테이블(4행)을 
   Cartesian Product을 일으켜서 총 48행을 만든다

SELECT NO, coll, dept, fre
FROM test11,
     (
        SELECT ROWNUM NO
        FROM dept
        WHERE ROWNUM < 5
     )A



3) rownum이 4번까지 있으므로 1번일 때 1학년, 2번일 때 2학년, .. 
   이런식으로 조건을 줄 수 있다는 것을 확인할 수 있으므로
   decode를 활용한다.

SELECT NO, coll, dept,
       decode(NO,1,fre,2,sup,3,jun,4,sen)
FROM test11,
     (
        SELECT ROWNUM NO
        FROM dept
        WHERE ROWNUM < 5
     )A
  
   

4)  dept가 가나다 순으로 정렬되어 있으므로
    ORDER BY를 dept를 기준으로 오름차 정렬한다.

SELECT NO, coll, dept,
       decode(NO,1,fre,2,sup,3,jun,4,sen)
FROM test11,
     (
        SELECT ROWNUM NO
        FROM dept
        WHERE ROWNUM < 5
     )A    
ORDER BY dept


5) 마지막으로 ALIAS 명과 함께 1~4학년의 인원수를 
   한 행씩 출력될 수 있도록 나눈다.

SELECT coll, dept,
       decode(NO,1,'1학년',2,'2학년',3,'3학년',4,'4학년') AS "KEY3",
       decode(NO,1,fre,2,sup,3,jun,4,sen) AS "KEY4"
FROM test11,
     (
        SELECT ROWNUM NO
        FROM dept
        WHERE ROWNUM < 5
     )
ORDER BY dept


6) KEY3 의 학년을 1-2-3-4학년 순서대로 출력될 수 있도록
   ORDER BY 정렬에 KEY3을 dept 다음으로 오름차 정렬될 수 있도록 한다.

SELECT coll, dept,
       decode(NO,1,'1학년',2,'2학년',3,'3학년',4,'4학년') AS "KEY3",
       decode(NO,1,fre,2,sup,3,jun,4,sen) AS "KEY4"
FROM test11,
     (
        SELECT ROWNUM NO
        FROM dept
        WHERE ROWNUM < 5
     )
ORDER BY dept ASC, key3 ASC
