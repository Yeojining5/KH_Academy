package com.day19;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest_1 {
	// 앞에 <> 제네릭
	// Object- 모든 클래스의 아버지, 정수 문자열을 모두 다 받음
	Map<String, Object> map = new HashMap<>();
	public MapTest_1() {
		// put - 데이터를 추가
		//printMap();
		// Map계열은 값을 담을 때 put메소드를 사용한다
		// 파라미터가 두 개 필요한데, 첫번째는 키값이고 두번째는 값이다.
		map.put("mem_id", "scott"); // 아이디
		map.put("mem_pw", "tiger"); // 비번
		map.put("mem_name", "나신입"); // 이름
		printMap(); // 출력을 담당하는 메소드 호출
	}
	
	public void printMap() {
		// 키값만을 추출할 때 사용한다.
		Set<String> set = map.keySet();
		// 키값이 세가지(mem_id, mem_pw, mem_name)이니까 배열에 담을 수 있다.
		Object obj[] = set.toArray(); // set을 이용해서 키값을 배열에 담았다.
		for(int i=0;i<obj.length;i++ ) {
			//형전환 연산자 사용 시 받아주는 타입을 적는 것이다.
			String key = (String)obj[i];
			System.out.println(key+", "+map.get(key)); // 순서대로 출력되지 않음(그대신 빠르다)			
		}
	}
	
	public static void main(String[] args) {
		new MapTest_1(); // 생성자 호출 (재사용할거 아니면 변수 선언 안해도됨)

	}

}
