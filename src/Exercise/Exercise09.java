package Exercise;

import java.util.Scanner;

public class Exercise09 {

	public static void main(String[] args) {
		
		/*
		 Ű����� �л� ���� �� �л����� ������ �Է¹޾Ƽ�, �ְ� ���� �� ��� ������ ���ϴ� ���α׷�
		 Scanner ���
		 */
		
		boolean a = true;
		Scanner scanner = new Scanner(System.in);	//����� Ű����� ���� �� �Է� ����
		int choice = 0;	//��ȣ ����
		int studentNumber = 0;	//�л� ��
		int scores[] = null;	//�л� ���� , �л� ���� �Է��ϸ� ����
		
		while(a)
		{
			System.out.println("--------------------------------------------------------");
			System.out.println("1.�л���|2.�����Է�|3.��������Ʈ|4.�м�|5.����");
			System.out.println("--------------------------------------------------------");
			System.out.print("�Է�>");
			choice = scanner.nextInt();
			
			if(choice == 1)
			{
				System.out.print("�л���>");
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
				System.out.println("�ְ� ���� : " + max);
				System.out.println("��� ���� : " + avg/scores.length);
			}
			else if(choice == 5) break;
		}
		
			System.out.println("���α׷� ����");

	}

}