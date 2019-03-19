package Exercise;

import java.util.Scanner;

public class Exercise07 {

	public static void main(String[] args) {
		
		boolean run = true;
		
		int select = 0;
		int account = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(run)
		{
			if(select != 13 && select != 10)
			{
				System.out.println("----------------------------------");
				System.out.println("1.예금|2.출금|3.잔고|4.종료");
				System.out.println("----------------------------------");
				System.out.print("선택>");
			}
			
			select=scanner.nextInt();
			if(select==1)
			{
				System.out.print("예금액>" );
				account+=scanner.nextInt();
			}
			else if(select==2)
			{
				System.out.print("예금액>" );
				account-=scanner.nextInt();
			}
			else if(select==3)
			{
				System.out.println("잔고>"+account);
			}
			else if(select==4)
				break;
		}
			System.out.println("프로그램 종료");

	}

}

/*while문과 Scanner를 이용해서 키보드로부터 입력된 데이터로 예금, 출금, 조회, 종료 기능을 제공하는 코드를 작성해보세요.
 * 이 프로그램을 실행시키면 다음과 같은 실행 결과가 나와야 합니다.
 */
