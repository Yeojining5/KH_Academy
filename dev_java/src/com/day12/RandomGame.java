package com.day12;

import java.util.Random;
import java.util.Scanner;

public class RandomGame {
	// 임의의 숫자를 채번하는 메소드를 제공하는 클래스임
	public static void gameStart() {
		Random r = new Random () ; // 디폴트생성자 호출이 일어난다
		// nextint 호출이다 (;으로 끝났으니까)
		// nextint의 소유주는 Random 클래스이다 = Random 클래스안에 nextint 메소드가 정의되어 있다(역할이 정해져있음)
		
		// 게임이 시작되기 전에 0부터 9사이의 임의의 수를 채번하기
		int dap = r.nextInt (10);// 0이상 10미만 사이의 정수를 리턴해준다 > API에 정의된 기준임
		// 사용자의 말을 듣기위해 인스턴스화한 것이다. 사용자가 입력한 값을 읽어올 때 - 듣기
		Scanner scan = new Scanner(System.in); // system-너의 노트북, in-입력장치
		
		System.out.println("0부터 9까지의 숫자를 입력하시오.");  // 안내 메세지 - 유효범위는 0~9
		String str = null;
		// scan한 값을 str 변수에 담아줘. null이 아니라면. 입력 안하면 기다림
		// while문 안의 실행문이 조건을 만족하지 않으면 실행 기회를 가질 수 없다 (do while은 무조건 한번 수행)
		while((str=scan.next()) != null) { //무한루프 방지코드가 꼭 있어야함(break) 서버다운 방지
			if(Integer.parseInt(str)==dap) {
				System.out.println("마따~"); // 반환타입이 있다면 return 적어줘야함
				break; // while문 전체를 빠져나온다.
			}
			else if(Integer.parseInt(str) > dap) {
				System.out.println("나차라~");
			}
			else if(Integer.parseInt(str) < dap) {
				System.out.println("노피라~");
			} // else 에는 조건문이 따로 없음 (이것도 저것도 아닌경우)
		} ///////////////////////////// while ended		
	}////////// end of gameStart /////////////////////////
	public static void main(String[] args) {
		RandomGame.gameStart(); // gameStart메서드가  static 이기 때문에 인스턴스화없이 호출함
	}//////////end of main ////////////////////////////////////////

}
// (인스턴스변수,참조변수 자리 = 소유주).parseInt()    >    Int로 변환해주는 메소드
// wrapper 클래스 > 원시형 타입을 참조형 타입으로 래핑.
// wrapper 클래스 > 원시형타입은 변수, 메소드를 가질 수 없다. (참조형은 가능)