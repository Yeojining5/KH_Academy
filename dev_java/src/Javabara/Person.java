package Javabara;

public class Person {	// Person 이라는 객체 안에
	String name = "홍길동";	 	// 멤버변수1(속성)
	int age = 40;		// 멤버변수2
			
	public void set_Name(String n) { 	//메서드1(행동)
		name = n;
	}
	
	public void set_Age(int i) {	//메서드2
		age = i;
	}
	
	public Person() {	 // 인자x 생성자
		this.name = "사람";
		this.age = 1;
	}
	
	public Person(String name, int age) {  		// 인자o 생성자
		this.name = name;
		this.age = age;
	}
	
	
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person("이여진", 29);
		p1.set_Name("홍길동");
		p1.set_Age(40);
		System.out.println( p2.name + "님의 나이는" + p2.age + "살 입니다.");

	}

}
