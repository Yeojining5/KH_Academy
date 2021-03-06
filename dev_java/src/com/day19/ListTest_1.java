package com.day19;

import java.util.ArrayList;
import java.util.List;
// 생성자도 메소드 오버로딩의 컨벤션을 따른다.
// 같은 이름의 생성자를 여러개 가질 수 있다.
public class ListTest_1 {
	// 다형성 누릴 수 있다.
	// 변수 list는 List타입이고, 구현체 클래스 이름은 ArrayList입니다.
	List<String> list = new ArrayList<>();
	//List<String> list2 = new ArrayList<>(); // 인터페이스 이름은 생성부에 올 수 없다.
	
	public ListTest_1() {
		System.out.println("디폴트 생성자 호출");
	}
	
	public ListTest_1(int i) {
		System.out.println("파라미터가 int인 생성자 호출");
		list.add("토마토");
		list.add(1,"딸기");
		list.add("수박");
	}
	
	public static void main(String[] args) {
		ListTest_1 lt = new ListTest_1(); //디폴트 생성자 호출
		// 인스턴스화만 되어있는 상태와 원소까지 추가된 상태인지를 구분해야 한다.
		int cnt = lt.list.size(); //0출력
		System.out.println(cnt);
		lt = new ListTest_1(10);
		cnt = lt.list.size(); //3출력
		System.out.println(cnt);
		
		
	}

}
