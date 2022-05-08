package com.day13;

public class Intialization_1 {
	int count;
	int hap = 0;

	public void initialize() {
		for (count = 1; count < 6; count++) {
			hap = hap + count;
			System.out.println("count : "+count);
			System.out.println("hap : "+hap);
		}

	}

	public static void main(String[] args) {
		Intialization_1 IN = new Intialization_1();
		IN.initialize();
	}
}
