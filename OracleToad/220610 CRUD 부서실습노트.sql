SELECT * FROM dept

INSERT INTO dept(deptno, dname, loc)
        VALUES(71,'°³¹ß1ÆÀ','¼­±ÍÆ÷')

int result = pstmt.executeUpdate();

SELECT * FROM dept
 WHERE deptno= 71
 

UPDATE dept
   set dname = '°³¹ß2ÆÀ', loc = '°ÅÁ¦µµ'
 WHERE deptno = 71
 
 
DELETE FROM dept
WHERE deptno IN (71,40)
 
 ROLLBACK