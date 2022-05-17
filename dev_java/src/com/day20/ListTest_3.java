package com.day20;

import java.util.ArrayList;
import java.util.List;

public class ListTest_3 {

	public static void main(String[] args) {
		List nameList2 = new ArrayList<>();
		nameList.add("나신입");
		System.out.println(nameList.size());
		String name = (String)nameList.get(0); // 타입이 object이므로 강제 형변환 해준것
		
		List<String> nameList2 = new ArrayList<>();
		nameList2.add("나초보");
		String name2 = nameList2.get(0); // 제네릭이 포함된 경우 형변환 필요 없음!
		
	}

}
