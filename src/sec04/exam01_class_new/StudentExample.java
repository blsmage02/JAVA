package sec04.exam01_class_new;

public class StudentExample {

	public static void main(String[] args) {
		
			Student s1 = new Student();
			System.out.println("s1 변수가 Student 객체를 참조합니다.");

			Student s2 = new Student();
			System.out.println("s2 변수가 또 다른 Student 객체를 참조합니다.");
	}

}
/*
스택에 s1 , s2 변수 생성
힙에 Student 객체 각 각 다른 번지 두 개 생성
*/ 