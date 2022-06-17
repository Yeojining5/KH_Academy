package ajdbc.member3;

public class MemberController {
	public final String _LOGIN 		= "login";
	public final String _SIGNUP 	= "membership";
	public final String _IDCHECK 	= "login";
	Member3VO mVO = null;
	
	///////////////////////////// 생성자 - 기준을 가져온다.. 사용자가 요청한 파라미터에 맞는 생성자가 필요함
	public MemberController() {}
	
	public MemberController(Member3VO mVO) {
		this.mVO = mVO;
	}
	
	
	public void action() {
		// LoginDao, MemberDao 생성하기
		String command = mVO.getCommand(); // mVO.getCommand() 가 반복된다 - 변수로 처리하기
		
		if(_LOGIN.equals(command)) {
			LoginDao loginDao = new LoginDao();
			String mem_name = null;
			mem_name = loginDao.login("사용자가 입력한 아이디", "사용자가 입력한 비번");
		} 
		else if(_SIGNUP.equals(command)) {
			System.out.println("MemberController 회원가입 호출 성공");
			MemberDao memDao =new MemberDao();
			int result = 0;
			result = memDao.memberInsert(mVO);
		} 
		else if(_IDCHECK.equals(command)) {
			LoginDao loginDao = new LoginDao();
			boolean isOk = loginDao.idCheck("사용자가 입력한 아이디값");
		}
	}
}
