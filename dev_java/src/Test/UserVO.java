package Test;
// 어떻게 기억되고 호출되는지가 중요!
// 데이터만 담을 수 있는 클래스 설계하기
// 접두어에 사용된 VO는 Value Object의 약자
// Vo : 자바의 변수와 오라클의 변수 사이를 매칭해주는 클래스 설계이름이다.
public class UserVO {
	// 전변의 위변조를 막기 위해서 private으로 선언한 뒤
	// 값을 꺼낼 때는 getter메소드를 호출하고
	// 값을 담을 때는 setter메소드의 파라미터를 통해서 복사된 값이 
	// 전역변수인 mem_id에 저장된다. (mem_pw, birth도 마찬가지)
	private String mem_id; // 아이디를 담을 변수
	private String mem_pw; // 비번을 담을 변수
	private String birth; // 생일을 담을 변수
	// 디폴트생성자가 있기에 RAM에 올라갈 수 있다. (재사용)
	public UserVO() {
	} // 디폴트 생성자 - 파라미터가 하나도 없는 생성자
	public UserVO(String mem_id, String mem_pw, String birth) {
		// 생성자의 역할 **전역변수의 초기화** **인스턴스 초기화 메서드**
		// 세 개의 파라미터를 갖는 생성자를 통해서 전역변수의 초기화가 가능함.
		this.mem_id = mem_id; // this가 붙은 mem_id만 전변, this가 없는 변수는 지변(파라미터에 있기 때문)\
		this.mem_pw = mem_pw;
		this.birth = birth;
	}
	public String getMem_id() {
		return mem_id;
	}
	// 접근제한자가 public 이므로 외부에서 접근 가능
	// 파라미터를 통해서 값이 전달되고 전변인 mem_id(7번라인)값이 담긴다, 저장된다.
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
}
