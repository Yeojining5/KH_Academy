package com.day21;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest4 {

	public static void main(String[] args) {
		// Object는 모든 클래스의 상위 클래스이다. 
		Map<String, Object> pmap = new HashMap<>();
		// 아래 3코드는 배열을 가지므로 배열에 담을 수 있다.
		pmap.put("one",  1);
		pmap.put("two",  2);
		pmap.put("three",  3);
		// pmap.put("three",  "apple");	애플이 올 수도 있음. object이니까
		Set<String> set = pmap.keySet();
		Object keys[] = set.toArray();
		for(Object key:keys) {
			System.out.println(key+", "+pmap.get(keys));		
		}
	}
}
