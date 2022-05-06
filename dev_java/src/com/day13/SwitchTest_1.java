package com.day13;

public class SwitchTest_1 {

	public static void main(String[] args) {
		int i = 1, j = -1;
		switch(i) {
		case 0, 1:
			j = 1; // j=1 저장, break 예약어가 없는 경우 default 값으로 출력
			break;
		case 2:
			j = 2;
		default :
			j = 0;
		}
		System.out.println("j = " +j);
	}

}
