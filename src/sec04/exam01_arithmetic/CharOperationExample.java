package sec04.exam01_arithmetic;

public class CharOperationExample {

	public static void main(String[] args) {
		
		char c1 = 'A' + 1;
		char c2 = 'A';
		//char c3 = c2 + 1; 산술 연산시 4바이트 int형으로 변환
		int result = c2 + 1;
		System.out.println(result);
		
		char c3 = (char) result;
		System.out.println(c3);
	}

}
