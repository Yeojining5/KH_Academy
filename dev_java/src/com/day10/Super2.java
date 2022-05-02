package com.day10;

public class Super2 {
	public float getNum() {
		return 3.0f;
	}

	public class sub2 extends Super2 {
		@Override
		public float getNum() {
			return 4.0f;
		}

		public double getNum(int i) { // 오버로딩
			return 4.0f;
		}

		public double getNum(double d) {
			return 4.0f;
		}

		public double getNum(float f) {
			return 4.0f;
		}

		public double getNum(float f, String name) {
			return 4.0f;
		}
	}

}
