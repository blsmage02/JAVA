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
				System.out.println("1.����|2.���|3.�ܰ�|4.����");
				System.out.println("----------------------------------");
				System.out.print("����>");
			}
			
			select=scanner.nextInt();
			if(select==1)
			{
				System.out.print("���ݾ�>" );
				account+=scanner.nextInt();
			}
			else if(select==2)
			{
				System.out.print("���ݾ�>" );
				account-=scanner.nextInt();
			}
			else if(select==3)
			{
				System.out.println("�ܰ�>"+account);
			}
			else if(select==4)
				break;
		}
			System.out.println("���α׷� ����");

	}

}

/*while���� Scanner�� �̿��ؼ� Ű����κ��� �Էµ� �����ͷ� ����, ���, ��ȸ, ���� ����� �����ϴ� �ڵ带 �ۼ��غ�����.
 * �� ���α׷��� �����Ű�� ������ ���� ���� ����� ���;� �մϴ�.
 */
