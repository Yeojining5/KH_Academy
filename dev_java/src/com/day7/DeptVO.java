package com.day7;
// 한 개 로우를 담을 수 있는 클래스 설계
// 여기에 사용된 변수들은 전역변수이다.

public class DeptVO {
	private int deptno = 0;
	private String dname = null; // 부서명을 담는 변수
	private String loc = null; //지역을 담는 변수
	// setter메소드와 getter메소드가 한쌍
	// setxxx 메소드는 쓰기, 저장이다
	// getxxx 메소드는 읽기이다.
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno; // this - 자기 자신을 나타내는 예약어 (DeptVO 자신) - 전변
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}

}


