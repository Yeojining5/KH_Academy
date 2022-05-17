package com.day20;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest_3 {

	Map<String, String> map = new HashMap<>();
	public MapTest_3() {
		// put - 데이터를 추가
		//printMap();
		// Map계열은 값을 담을 때 put메소드를 사용한다
		// 파라미터가 두 개 필요한데, 첫번째는 키값이고 두번째는 값이다.
		map.put("mem_id", "scott"); // 아이디
		map.put("mem_pw", "tiger"); // 비번
		map.put("mem_name", "나신입"); // 이름
		// 선언이 먼저 호출은 나중에
		printMap(); // 출력을 담당하는 메소드 호출
	} //////////////////// end of default 생성자
	
	public void printMap() { // entrySet활용
		System.out.println(map.size()); // 키값에 대한 원소의 수이다. - 3출력 
		// (Set<Map.Entry<K,V>> - key, value
		// Integer.parseInt와 비슷한 구문. static개념
		// Map안에 엔트리 타입이 있다.
		// 9번라인에서 정의된 클래스를 사용하므로 제네릭 타입이 변하면 아래에서도 동일하게 바꿔야 함 String, String
		for(Map.Entry<String,String> et:map.entrySet()) {
			System.out.println("[key] : "+et.getKey()+", [value] : "+et.getValue()); // et. > 소유주는 entry
		}
		
	}
	
	public static void main(String[] args) {
		new MapTest_3();
	}

}
