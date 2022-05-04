package Test;
// 변수 선언시 타입 앞에 final이 있으면 상수가 된다.
// 메소드 앞에 final이 오면 오버라이딩이 안된다.
// 클래스 앞에 final이 오면 상속이 안된다.
public class Exam2 {

	String name = "이순신";
	final double PI = 3.14;	// 원주율 3.14는 변하지 않는 수이기 때문
	
	public static void main(String[] args) {
		Exam2 e2 = new Exam2();
		System.out.println(e2.name);
		System.out.println(e2.PI);
		//e2.PI = 5.1; // 컴파일에러 상수로 선언되었으므로 재정의 불가


	}

}
