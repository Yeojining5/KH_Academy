* 220615 CRUD 설계 - 회원 관리 시스템

SELECT mem_no, mem_id, mem_pw, mem_name, mem_zipcode, mem_address
 FROM member
  
<ID 중복체크!!>

SELECT 1
FROM dual
WHERE EXISTS (SELECT mem_name
                FROM member
                WHERE mem_id =:x)
                
INSERT INTO member(mem_no, mem_id, mem_pw, mem_name, mem_zipcode, mem_address)
VALUES (4, 'nice', '123', '이순신', '12345', '서울시 마포구 공덕동')
-- 단위테스트용
-- 멤버번호에는 시퀀스를 넣어서 자동으로 번호가 채번되도록 할 예정임

ROLLBACK;

seq_member_no --시퀀스

SELECT * FROM user_sequences 
-- 정의된 시퀀스 조회

CREATE SEQUENCE seq_member_no
       INCREMENT BY 1
       START WITH 5
       MINVALUE 5
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;
       
 DELETE FROM member
 WHERE mem_no = 0