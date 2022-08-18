package mvc.kh;

import org.apache.log4j.Logger;
// 리액트와 조인
// DAO[JSON포맷출력, XML포맷출려기:DataSet] - Data Access Object - 오라클 서버와 연계하기만 전담 클래스
// XXXLogic클래스의 하나의 메소드 안에 여러개의 Dao의 메소드 호출을 받아 낸다
// 여러개의 Dao메소드를 호출한다는 것은 업무에 대한 프로세스 알고 있다 -  판단
// 모델계층의 일부이다 - DAO가 있고 없고는 MVC기준이 아니다
// DataSet은 프론트앤드와 만난다 - 응답
// MyBatis와 같은 ORM솔루션 연계 - 클래스설계 -  MyBatis와의 의존관계 포함
// 의존관계에 대해 말 할 수 있는 개발자
public class LoginDao {
	Logger logger = Logger.getLogger(LoginDao.class);

	public String login(String mem_id, String mem_pw) {
		String mem_name = null;
		mem_name = "이순신";
		//mem_name = null;
		return mem_name;
	}
	
}
