package mvc.kh;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class NoticeService {
	Logger logger = Logger.getLogger(NoticeService.class);
	public ArrayList<Notice> selectList() {
		logger.info("selectList호출 성공");
//		ArrayList<Notice> list = new ArrayList<>();
		ArrayList<Notice> list = null;
		try {
			Notice notice = new Notice();
			notice.setTitle("제목1");
			notice.setWriter("이순신");
			notice.setContent("내용1");
			list.add(notice);
			notice = new Notice();
			notice.setTitle("제목2");
			notice.setWriter("김유신");
			notice.setContent("내용2");
			list.add(notice);
			notice = new Notice();
			notice.setTitle("제목3");
			notice.setWriter("강감찬");
			notice.setContent("내용3");
			list.add(notice);
			
		} catch (NullPointerException e) {
			logger.info("선언만 했네");
		}
		return list;
	}

}
