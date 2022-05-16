package Quiz0516;

// -10에서 10사이의 정수 10개를 랜덤하게 채번하여 음수와 양수의 합계를 구하시오.
// [요구사항 : 채번한 숫자는 1차 배열에 담아서 처리해 주세요]

public class PositiveNegativeHap_2 {

	int nanSu[] = new int[10]; // 난수 10개를 담을 배열 선언
	int positiveHap; // 양수의 합을 담을 변수 선언
	int negativeHap; // 음수의 합을 담을 변수 선언
		
	public PositiveNegativeHap_2(int positiveHap, int negativeHap ) {
		this.positiveHap = positiveHap;
		this.negativeHap = negativeHap;
		extractnumber(); // -10에서 10사이의 정수 10개를 랜덤하게 채번하는 메소드 호출
	}
	
	public void extractnumber() {
		System.out.printf("배열 :");
		for (int i = 0; i < nanSu.length; i++) {
			nanSu[i] = (int) ((Math.random() * 21) - 10); // -9 ~ 10 포함 정수 출력
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
		new PositiveNegativeHap_2(0, 0); // 생성자 호출

	}

}
