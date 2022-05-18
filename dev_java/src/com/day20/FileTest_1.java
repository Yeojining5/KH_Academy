package com.day20;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
// FileWriter 클래스는 문자열을 파일에 출력할 때 사용. txt파일에 저장
public class FileTest_1 {
// API > java.io > [Classes] FilterWriter
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			// new FileWriter("파일경로")
			fw = new FileWriter("C:\\Users\\user\\git\\Yeojin\\dev_java\\src\\com\\day20\\log.txt", true);
			fw.write(65); // 아스키코드 A
			fw.write(97); // 아스키코드 a
			fw.write(70); 
		} catch (FileNotFoundException fe) {
			System.out.println("해당 파일을 찾을 수 없습니다.");
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		} catch (Exception e) {
			// 예외가 발생했을 때 에러상황을 기록해두는 stack메모리 영역에 있는
			// 에러메시지를 라인번호와 함께 출력해주는 메소드 입니다. *** 자주사용함! 기억해줘
			// 주의사항! 절대로 print 메소드 안에서 사용하지 말 것.
			e.printStackTrace(); // 에러 발생 시 좀더 자세한 힌트문을 수집할 때 사용한다 (디버깅 함수)
		} finally {
			try {
				// 입출력의 경우 악의적인 목적으로 접근하여 외부에 노출될 수 있으므로
				// 사용한 객체는 반드시 닫아야 하는 컨벤션이 있다.
				fw.close(); //사용한 자원을 닫아줘야 한다. 반드시! (권장사항)
			} catch (Exception e2) {
				// TODO: handle exception
			}
		} ////////////// end of finally
	} /////////// end of main

}
