package com.day12;

import java.util.Random;
import java.util.Scanner;

public class RandomGame_1 {
	public void gameStart() {
		Random r = new Random () ; 
		int dap = r.nextInt (10);
		
		Scanner scan = new Scanner(System.in); 
		
		System.out.println("0부터 9까지의 숫자를 입력하시오."); 
		String str = null;
		
		for(;(str=scan.next()) != null;) { 
			if(Integer.parseInt(str)==dap) {
				System.out.println("마따~"); 
				break; 
			}
			else if(Integer.parseInt(str) > dap) {
				System.out.println("나차라~");
			}
			else if(Integer.parseInt(str) < dap) {
				System.out.println("노피라~");
			} 
		} ///////////////////////////// while ended		
	}////////// end of gameStart /////////////////////////

	public static void main(String[] args) {
		RandomGame_1 rg = new RandomGame_1();
		rg.gameStart();
	}////////// end of main ////////////////////////////////////////

}
// (인스턴스변수,참조변수 자리 = 소유주).parseInt()    >    Int로 변환해주는 메소드
// wrapper 클래스 > 원시형 타입을 참조형 타입으로 래핑.
// wrapper 클래스 > 원시형타입은 변수, 메소드를 가질 수 없다. (참조형은 가능)