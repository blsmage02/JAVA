package honux.calendar;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
//		
//		System.out.print("첫 번째 값 입력 : ");
//		int num1 = scanner.nextInt();
//		
//		System.out.print("두 번째 값 입력 : ");
//		int num2 = scanner.nextInt();
//		
//		System.out.println("두 수의 합은 : " + (num1 + num2));
//		
		
		String s1, s2;
		
		s1 = scanner.next();
		s2 = scanner.next();
		
		System.out.println(s1 + " , " + s2);
		
		int a, b;
		
		
		a = Integer.parseInt(s1);
		b = Integer.parseInt(s2);
		
		System.out.println(a + " , " + b);
		
		int c = a + b;
		
		System.out.println("두 수의 합은 : " + c);
		
		scanner.close();

	}

}
