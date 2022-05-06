package com.day13;

public class FizzBuzzGame_1 {

	public static void main(String[] args) {
		int i; 
		i = 1;
		while (i < 101) {
			if((i%5==0) && (i%7==0)) {
				System.out.println("FizzBuzz");
			}else if (i%5==0) {
				System.out.println("Fizz");
			}else if (i%7==0) {
				System.out.println("Buzz");
			}else {
				System.out.println(i);
			}
			++i;
		} /////////////////////////// end of while
	}/////////////////////////////// end of main
}/////////////////////////////////// end of FizzBuzzGame
