package com.day19;
//List > API 기반
import java.util.ArrayList;
import java.util.List;

public class ListTest_2 {
	List<String> list = new ArrayList<>();
	
	public void setList() {
		list.add("수박");
		list.add("토마토");
		list.add("사과");
	}
	
	public void printList() {
		setList();
		// list 삭제하는 remove 메소드를 String 변수 ele에 담는다
		String ele = list.remove(1);  // 두번째 것 삭제 (배열과 같이 0번지로 시작한다 = 첫번째 인덱스가 0)
		boolean isFail = list.remove("사과"); // 파라미터에 object가 오면 리턴타입이 boolean으로 정해져있음(API) > if문을 떠올려라
		list.add("바나나"); // 값을 추가
		String ele2 = list.get(0);
		String ele3 = list.set(0, "참외");
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("삭제된 요소는 " +ele+ "입니다");
		System.out.println("응답 결과 값" +isFail);
		System.out.println("바나나 있니? "+list.contains("바나나")+", "+"키위는? "+list.contains("키위"));
		if(list.contains("바나나")) {
			System.out.println("바나나 있습니다. 드릴까요?");
		System.out.println("get "+ele2);
		}
	}
	
	public static void main(String[] args) {
		ListTest_2 lt = new ListTest_2(); //디폴트 생성자 호출
		lt.printList(); // 수박 토마토 사과 가 출력되어야 하는데, 토마토는 삭제되어 출력됨
		
		
	}

}
