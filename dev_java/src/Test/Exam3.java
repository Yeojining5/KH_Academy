package Test;

public class Exam3 {

	public static void main(String[] args) {
		//원시형 타입은 부르면 값이 나온다.
		//참조형 타입은 부르면 주소번지가 출력된다.
		//참조형변수는 전역변수를 여러번 선언할 수 있다.
		boolean isFail = false;
		Exam3 e3 = new Exam3();
		System.out.println(e3);
		
		// 디폴트 생성자가 호출된다
		// uVO를 인스턴스(참조형) 변수라 한다.
		// 디폴트 생성자를 호출했을 때는 
		// mem_id = null, mem_pw = null, birth = null 이렇게 초기화
		UserVO uVO = new UserVO();
		// mem_id = "banana", mem_pw = "156", birth = "1999-12-25" 이렇게 초기화
		//uVO = new UserVO("banana", "156", "1999-12-25"); // 주석풀면 파라미터 값으로 출력됨
		//System.out.println(uVO.mem_id); 에러-접근 제한자가 private이므로 클래스 외부에서 접근 불가
		System.out.println(uVO.getMem_id());
		System.out.println(uVO.getMem_pw());
		System.out.println(uVO.getBirth());
	}

}
