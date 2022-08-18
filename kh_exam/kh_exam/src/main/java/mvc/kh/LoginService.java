package mvc.kh;

import org.apache.log4j.Logger;

// 여러개의 Dao를 호출할 수 있다. - 트랜잭션 처리
// 하나의 테이블에서 조회된 정보를 가지고 A테이블에는 insert  B테이블에는 update처리한다 - 하나의 업무
// 트랜잭션 처리는 로직클래스에서 해야만 한다.
public class LoginService {
	Logger logger = Logger.getLogger(LoginService.class);
	// 이른 인스턴스화 이다.(스프링) - 멤버
	// 게으른 인스턴스화 이다.- 필요할 때 바로 직전에 주입해줌 - 효율성 - NullPointerException
	// 로컬성격 - 지변
	// LoginService인스턴스화 될 때 LoginDao클래스도 인스턴스화 된다
	LoginDao loginDao = new LoginDao();
	public String login(String mem_id, String mem_pw) {
		String mem_name = null;
		mem_name = loginDao.login(mem_id, mem_pw);
		return mem_name;
	}
}
