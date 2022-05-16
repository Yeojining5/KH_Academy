package Quiz0516;

// -10에서 10사이의 정수 10개를 랜덤하게 채번하여 음수와 양수의 합계를 구하시오.
// [요구사항 : 채번한 숫자는 1차 배열에 담아서 처리해 주세요]

public class PositiveNegativeHap_3 {

	int positiveHap; // 양수의 합을 담을 변수 선언
	int negativeHap; // 음수의 합을 담을 변수 선언

	public void extractnumber(int nanSu[]) {
		System.out.printf("배열 :");
		// 개선된 for문, 배열의 인덱스만큼 반복, nanSu를 int nanSus에 저장
		for (int nanSus : nanSu) {
			nanSus = (int) ((Math.random() * 21) - 10); // -9 ~ 10 포함 정수 출력
			System.out.printf("%3d", nanSus);

			if (nanSus < 0) {
				negativeHap += nanSus;
			} else {
				positiveHap += nanSus;
			}
		} //////////////////////// end of for
		System.out.println("");
		System.out.printf("%n음수의 합 : %d", negativeHap);
		System.out.printf("%n양수의 합 : %d", positiveHap);
	} /////////////////////////// end of method

	public static void main(String[] args) {
		PositiveNegativeHap_3 pn = new PositiveNegativeHap_3();

		int nanSu[] = new int[10]; // 난수 10개를 담을 배열 선언 (지역 변수)
		pn.extractnumber(nanSu); // 메소드의 파라미터와 타입을 맞춘다
	}

}
