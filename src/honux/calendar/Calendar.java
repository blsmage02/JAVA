package honux.calendar;

import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
		
		final int[] GetMaxDaysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		Scanner scanner = new Scanner(System.in);
		String PROMPT = "cal> ";

		int number;
		
		while(true)
		{
			System.out.println("달을 입력하세요.");
			System.out.print(PROMPT);
			number = scanner.nextInt();
			
			if(number == -1) break;
			
			if(number > 12) continue;
			
			int result = GetMaxDaysOfMonth[number - 1];
			
			System.out.println(number + "월은 " + result + "일 까지 있습니다.");
		}
		
		System.out.println("bye~");
		scanner.close();


	}

}
//
//달을 입력하세요.
//3 (엔터)
//3월은 31일까지 있습니다.