SELECT * FROM hd_video_member_t

누가 언제 어떤 비디오를 대여 했는지 알고 싶다.
만일 미반납 상태이면 전화를 걸어 반납 요청을 해야 한다면
어떤 집합들이 필요할지 적어보세요.

--마스터에 있는 대여번호와 디테일에 있는 대여번호가 같니? 조건을 줘야 카타시간곱X

SELECT vm.loan_no AS "대여번호",
       vm.loan_date AS "대여일자",
       vm.mem_cd AS "회원코드"
  FROM HD_VIDEO_LOAN_DETAIL_T vd, 
       HD_VIDEO_LOAN_MAST_T vm 
 WHERE vm.loan_no = vd.loan_no

SELECT *
 FROM  HD_VIDEO_LOAN_DETAIL_T vd, 
       HD_VIDEO_LOAN_MAST_T vm,
       HD_VIDEO_MEMBER_T mem  
-- 총 540건

SELECT vm.loan_no AS "대여번호",
       vm.loan_date AS "대여일자",
       mem.mem_name AS "회원명",
       mem.mem_tel AS "전화번호"
 FROM  HD_VIDEO_LOAN_DETAIL_T vd, 
       HD_VIDEO_LOAN_MAST_T vm,
       HD_VIDEO_MEMBER_T mem,  
WHERE vm.loan_no = vd.loan_no
 AND vm.mem_cd = mem.mem_cd
 
 
 
SELECT vm.loan_no AS "대여번호",
       vm.loan_date AS "대여일자",
       mem.mem_name AS "회원명",
       mem.mem_tel AS "전화번호",
       M.movie_name AS "영화명"
 FROM  HD_VIDEO_LOAN_DETAIL_T vd, 
       HD_VIDEO_LOAN_MAST_T vm,
       HD_VIDEO_MEMBER_T mem,
       HD_MOVIE_T M,
       HD_VIDEO_T V
WHERE vm.loan_no = vd.loan_no
 AND vm.mem_cd = mem.mem_cd
 AND V.MOVIE_CD = M.movie_cd
 AND vd.video_cd = v.video_cd
 
