package Quiz0516;

// -10에서 10사이의 정수 10개를 랜덤하게 채번하여 음수와 양수의 합계를 구하시오.
// [요구사항 : 채번한 숫자는 1차 배열에 담아서 처리해 주세요]

public class PositiveNegativeHap_1 {

	int nanSu[] = new int[10]; // 난수 10개를 담을 배열 선언
	int positiveHap = 0; // 양수의 합을 담을 변수 선언
	int negativeHap = 0; // 음수의 합을 담을 변수 선언

	public void extractnumber() {
		System.out.printf("배열 :");
		for (int i = 0; i < nanSu.length; i++) {
			nanSu[i] = (int) ((Math.random() * 21) - 10); // 0.0 <= x <1.0 사이의 실수
			System.out.printf("%3d", nanSu[i]);
			
			if (nanSu[i] < 0) {
				negativeHap += nanSu[i];
			} else {
				positiveHap += nanSu[i];
			}
		} //////////////////////// end of for
		System.out.println("");
		System.out.printf("%n음수의 합 : %d", negativeHap);
		System.out.printf("%n양수의 합 : %d", positiveHap);
	} /////////////////////////// end of method

	public static void main(String[] args) {
		PositiveNegativeHap_1 pn = new PositiveNegativeHap_1();
		pn.extractnumber(); // -10에서 10사이의 정수 10개를 랜덤하게 채번하는 메소드 호출

	}

}
