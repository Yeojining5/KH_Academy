SELECT * FROM hd_video_member_t

���� ���� � ������ �뿩 �ߴ��� �˰� �ʹ�.
���� �̹ݳ� �����̸� ��ȭ�� �ɾ� �ݳ� ��û�� �ؾ� �Ѵٸ�
� ���յ��� �ʿ����� �������.

--�����Ϳ� �ִ� �뿩��ȣ�� �����Ͽ� �ִ� �뿩��ȣ�� ����? ������ ��� īŸ�ð���X

SELECT vm.loan_no AS "�뿩��ȣ",
       vm.loan_date AS "�뿩����",
       vm.mem_cd AS "ȸ���ڵ�"
  FROM HD_VIDEO_LOAN_DETAIL_T vd, 
       HD_VIDEO_LOAN_MAST_T vm 
 WHERE vm.loan_no = vd.loan_no

SELECT *
 FROM  HD_VIDEO_LOAN_DETAIL_T vd, 
       HD_VIDEO_LOAN_MAST_T vm,
       HD_VIDEO_MEMBER_T mem  
-- �� 540��

SELECT vm.loan_no AS "�뿩��ȣ",
       vm.loan_date AS "�뿩����",
       mem.mem_name AS "ȸ����",
       mem.mem_tel AS "��ȭ��ȣ"
 FROM  HD_VIDEO_LOAN_DETAIL_T vd, 
       HD_VIDEO_LOAN_MAST_T vm,
       HD_VIDEO_MEMBER_T mem,  
WHERE vm.loan_no = vd.loan_no
 AND vm.mem_cd = mem.mem_cd
 
 
 
SELECT vm.loan_no AS "�뿩��ȣ",
       vm.loan_date AS "�뿩����",
       mem.mem_name AS "ȸ����",
       mem.mem_tel AS "��ȭ��ȣ",
       M.movie_name AS "��ȭ��"
 FROM  HD_VIDEO_LOAN_DETAIL_T vd, 
       HD_VIDEO_LOAN_MAST_T vm,
       HD_VIDEO_MEMBER_T mem,
       HD_MOVIE_T M,
       HD_VIDEO_T V
WHERE vm.loan_no = vd.loan_no
 AND vm.mem_cd = mem.mem_cd
 AND V.MOVIE_CD = M.movie_cd
 AND vd.video_cd = v.video_cd
 
