package com.day10;

public class Z {

	public static void main(String[] args) {
		int i = 2;
		int j = i++; // 후위연산자 - 대입이 먼저 이루어지고 그다음 증가된다. => i=i+1
		if ((i == ++j) | (i++ == j)) { 
			i += j;

		}
		System.out.println("i = " + i);
	}

}
