* 220615 CRUD ���� - ȸ�� ���� �ý���

SELECT mem_no, mem_id, mem_pw, mem_name, mem_zipcode, mem_address
 FROM member
  
<ID �ߺ�üũ!!>

SELECT 1
FROM dual
WHERE EXISTS (SELECT mem_name
                FROM member
                WHERE mem_id =:x)
                
INSERT INTO member(mem_no, mem_id, mem_pw, mem_name, mem_zipcode, mem_address)
VALUES (4, 'nice', '123', '�̼���', '12345', '����� ������ ������')
-- �����׽�Ʈ��
-- �����ȣ���� �������� �־ �ڵ����� ��ȣ�� ä���ǵ��� �� ������

ROLLBACK;

seq_member_no --������

SELECT * FROM user_sequences 
-- ���ǵ� ������ ��ȸ

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