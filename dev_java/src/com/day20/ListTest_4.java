package com.day20;

import java.util.ArrayList;
import java.util.List;

public class ListTest_4 {

	public static void main(String[] args) {
		
		List<Integer> numberList = new ArrayList<>();
		numberList.add(5);
		Integer num = numberList.get(0);
		int num2 = numberList.get(0);
		
		int name2 = numberList.get(0); // 제네릭이 포함된 경우 형변환 필요 없음!
		System.out.println(num);
	}

}
