package Exercise;

import java.util.Scanner;

public class Exercise09 {

	public static void main(String[] args) {
		
		/*
		 키보드로 학생 수와 각 학생들의 점수를 입력받아서, 최고 점수 및 평균 점수를 구하는 프로그램
		 Scanner 사용
		 */
		
		boolean a = true;
		Scanner scanner = new Scanner(System.in);	//사용자 키보드로 부터 값 입력 받음
		int choice = 0;	//번호 선택
		int studentNumber = 0;	//학생 수
		int scores[] = null;	//학생 점수 , 학생 수를 입력하면 대입
		
		while(a)
		{
			System.out.println("--------------------------------------------------------");
			System.out.println("1.학생수|2.점수입력|3.정수리스트|4.분석|5.종료");
			System.out.println("--------------------------------------------------------");
			System.out.print("입력>");
			choice = scanner.nextInt();
			
			if(choice == 1)
			{
				System.out.print("학생수>");
				studentNumber = scanner.nextInt();
				scores = new int[studentNumber];
			}
			else if(choice == 2)
			{
				for(int i = 0; i < scores.length;i++)
				{
					System.out.print("scores["+i+"]>");
					scores[i] = scanner.nextInt();
				}
			}
			else if(choice == 3)
			{
				for(int i = 0; i<scores.length;i++)
				{
					System.out.print("scores["+i+"]>");
					System.out.println(scores[i]);
				}
			}
			else if(choice == 4)
			{
				int max = 0;
				double avg = 0;
				for(int score : scores)
				{
					if(max<score) max=score;
					avg += score;
				}
				System.out.println("최고 점수 : " + max);
				System.out.println("평균 점수 : " + avg/scores.length);
			}
			else if(choice == 5) break;
		}
		
			System.out.println("프로그램 종료");

	}

}