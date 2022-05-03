package Test;

import java.util.Scanner;

public class Test1 {
	String exit = "exit";
	//public Test1() {} // 생략이 가능함 - 단 생성자가 하나도 선언된게 없을 때만 
	public void count() {
		Scanner sc = new Scanner(System.in);
		while (true){
			System.out.print("문자열을 입력해주세요 : ");
			String str = sc.nextLine(); // nextLine의 리턴타입이 void라면 대입연산자를 써서 받을 수 없다. - 메소드의 재사용성
			if ("exit".equals(str)) { // "exit" 이라는 문자열 상수를 사용하는 것이 안전
				break;
			} else {
				System.out.println(str.length() + "글자 입니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}
	/* JVM 실행 순서
	 * 25-26[인스턴스화]-27[메소드 호출]-7-8[사용자가 콘솔에 입력한 값 입력받기]-9[while:반복문, 괄호안이 false이면 실행불가]
	 * 10-11[입력문자 저장됨]-12[입력문자가 exit과 같은 문자열인지 비교]-13[12번 조건이 참이면 실행됨:break호출하면 while문 탈출함]	
	 * 14[사용자가 입력한 문자열이 exit이 아닐때 실행됨]-15-17-18
	 */
	public static void main (String[] args) {
		Test1 t = new Test1() ; // 디폴트생성자 호출이 동시에 일어남
		t.count();
	}
	
}

// while문 다음에 괄호안에는 boolean 타입이 온다.
// while문 좌,우중괄호 안에 있는 코드를 실행문 이라고 한다.
// 이 실행문은 괄호안에  true 일때만 실행된다.
// 괄호안에 false이면 실행문은 한 번도 실행기회를 갖지 못한다.
