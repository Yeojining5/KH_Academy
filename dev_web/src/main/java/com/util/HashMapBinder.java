package com.util;

import java.io.File;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
/*
 * 텍스트 파일 처리(문자열 처리)- 숫자도 문자열 처리 -  숫자도 문자열로 처리 후 변경해서 출력
 * 바이너리 파일 처리(문자+숫자 파일) - 첨부파일은 바이너리 코드
 * 사용자가 화면에 입력하는 값을 받아오기 위해서 공통 코드를 만듦
 * 오라클 테이블의 컬럼의 수가 50개이면 req.getParameter()를 50번 써야 하는 것임
 * 산업과 관련된 테이블의 컬럼 수는 100개 이상 200개 인 것도 다반사 임
 * 따라서 스프링과 같은 프레임워크에서는 반복되는 코드를 줄이기 위한 유틸 기능의 클래스도 지원함
 */
public class HashMapBinder {
	Logger logger = Logger.getLogger(HashMapBinder.class);
	HttpServletRequest req = null;
	//첨부 파일 처리에 필요한 변수 선언 - 바이너리 타입 처리를 위해
	MultipartRequest multi = null;
	//첨부 파일 업로드의 물리적인 경로 이름
	String realFolder = null;
	//첨부파일의 한글 처리
	String encType = "utf-8";
	//첨부파일의 최대 크기
	int maxSize = 5*1024*1024;//5MB
	public HashMapBinder(HttpServletRequest req) {
		this.req = req;
		realFolder = "C:\\Users\\user1\\git\\dev_java20220415\\dev_web\\src\\main\\webapp\\pds";
	}
	public void multiBind(Map<String,Object> pMap) {
		pMap.clear();
		try {
			multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		} catch (Exception e) {
			logger.info("Exception:"+e.toString());
		}
		Enumeration<String> em = multi.getParameterNames();
		while(em.hasMoreElements()) {
			String key = em.nextElement();
			pMap.put(key, multi.getParameter(key));
		}
		//기존에 클라이언트에서 받아온 정보를 처리하기
		//첨부파일에 대한 정보 받아오기
		Enumeration<String> files = multi.getFileNames();
		//만일 폼 전송에서 업로드할 파일명이 존재하면...
		if(files !=null) {
			//업로드 대상 파일을 객체로 만듦
			File file = null;
			while(files.hasMoreElements()) {
				String fname = files.nextElement();
				String filename = multi.getFilesystemName(fname);
				pMap.put("bs_file", filename);
				if(filename !=null && filename.length()>1) {
					file = new File(realFolder+"\\"+filename);
				}
				logger.info(file);
			}
			//첨부 파일에 크기를 담을 수 있는 변수 선언
			double size = 0;
			if(file!=null) {
				size = file.length();
				size = size/1024.0;//byte-> kbyte
				pMap.put("bs_size", size);
			}
		}
	}
	public void bind(Map<String,Object> pMap) {
		//사용자가 입력한 값을 담을 맵이 외부 클래스에서 인스턴스화 되어 넘어오니까
		//초기화 처리 후 사용함
		pMap.clear();//  초기화를 해줌
		//html화면에 정의된 input name값들을 모두 담아줌
		Enumeration<String> em = req.getParameterNames();
		while(em.hasMoreElements()) {
			//key값 꺼내기
			String key = em.nextElement();//b_title, b_writer, b_content, b_pw 등
			pMap.put(key, req.getParameter(key));
		}
		logger.info(pMap);
	}//////////end of bind
}
