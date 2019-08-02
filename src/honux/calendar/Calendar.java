package honux.calendar;

import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
		
		final int[] GetMaxDaysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("반복횟수를 입력하세요 : ");
		int repeat = scanner.nextInt();
	
		
		System.out.println("일 월 화 수 목 금 토");
		System.out.println("--------------------");
		System.out.println("1  2  3  4  5  6  7");
		System.out.println("8  9 10 11 12 13  14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		
		
		for(int i = 0; i < repeat; i++)
		{
			System.out.print("달을 입력하세요 : ");
			int number = scanner.nextInt();
			
			int result = GetMaxDaysOfMonth[number - 1];
			
			System.out.println(number + "월은 " + result + "일 까지 있습니다.");
		}
		
		scanner.close();


	}

}
//
//달을 입력하세요.
//3 (엔터)
//3월은 31일까지 있습니다.