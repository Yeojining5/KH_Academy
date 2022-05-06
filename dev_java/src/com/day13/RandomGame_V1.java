package com.day13;

import java.util.Random;
import java.util.Scanner;

public class RandomGame_V1 {

	public void gameStart() {
		// 게임 유저들에게 회차정보를 주기위한 힌트 변수(요구사항으로 설정된 변수)
		// 높여라 or 낮춰라 힌트를 준다면 기회를 한 번 잃어버린다. (--로 차감)
		int cnt = 5;
		Random r = new Random();

		int dap = r.nextInt(10);

		Scanner scan = new Scanner(System.in);

		System.out.println("0부터 9까지의 숫자를 입력하시오.");
		String str = null;

		for (int i=1;i<6;i++) {
			str = scan.next();
			// if는 매번 조건을 따지지만 else if문을 사용하면 첫번째 조건이
			// 만족되었을 경우 아래 조건은 따지지 않고 if문 블록을 탈출한다.
			
			if(i==5) {
				System.out.println("더 이상 기회는 없습니다.");
				break;
			}
			if (Integer.parseInt(str) == dap) {
				System.out.println("마따~");
				break;
			} else if (Integer.parseInt(str) > dap) {
				cnt--;
				System.out.println("나차라~");
			} else if (Integer.parseInt(str) < dap) {
				cnt--;
				System.out.println("노피라~");
			}
			// 5번 기회 중 3번째 정답을 맞추면 나간다.
			// 5번을 초과해서 사용자가 입력을 할 수 있나요?
		} ///////////////////////////// while ended
	}////////// end of gameStart /////////////////////////

	public static void main(String[] args) {
		RandomGame_V1 rv = new RandomGame_V1();
		rv.gameStart();
	}////////// end of main ///////////////////////////////////

}
