package honux.calendar;

import java.util.Scanner;

public class Calendar {
	
	private static final int[] MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int GetMaxDaysOfMonth(int number)
	{
		return MONTH[number - 1];
	}
	

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("달을 입력하세요 : ");
		int number = scanner.nextInt();
		
		Calendar cal = new Calendar();
		
		System.out.println("일 월 화 수 목 금 토");
		System.out.println("--------------------");
		System.out.println("1  2  3  4  5  6  7");
		System.out.println("8  9 10 11 12 13  14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	
		
		System.out.println(number + "월은 " + cal.GetMaxDaysOfMonth(number) + "까지 있습니다.");
		
		
		scanner.close();
		


	}

}
//
//달을 입력하세요.
//3 (엔터)
//3월은 31일까지 있습니다.