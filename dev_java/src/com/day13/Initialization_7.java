package com.day13;

public class Initialization_7 {
	int count;
	int hap = 0;

	public void account() {
		for (count = 1; count < 6; count++) {
			hap = hap + count;
		}
		System.out.println("after count : " + count);
		System.out.println("after hap : " + hap);// 출력 문장은 for문 바깥에!

		count = 1;
		hap = 0; // 여기를 주석처리하면 hap이 15+9로 24가 된다 **초기화가 안되었기 때문**
		for (; count < 6; count++) {
			System.out.println("count : " +count+ ", hap : "+hap);
			if (count % 2 == 1)
				hap = hap + count;
		}
		System.out.println("홀수의 합은 : " + hap);

		count = 1;
		hap = 0;
		for (; count < 6; count++) {
			if (count % 2 == 0)
				hap = hap + count;
		}
		System.out.println("짝수의 합은 : " + hap);
	}

	public static void main(String[] args) {
		Initialization_7 i3 = new Initialization_7();
		i3.account();

	}

}
