package sec03.exam03_dowhile;

import java.util.Scanner;

public class DoWhileExample {

	public static void main(String[] args) {
		
		System.out.println("�޼����� �Է��ϼ���.");
		System.out.println("���α׷��� �����Ϸ��� q�� �Է��ϼ���.");
		
		Scanner scanner = new Scanner(System.in);
		String inputString;
		
		int i=0;
		
		do {
			System.out.print(">");
			inputString = scanner.nextLine();
			System.out.println(inputString);
		}while(! inputString.equals("q"));
		
		System.out.println();
		System.out.println("���α׷� ����");

	}

}

/*
Scanner ����� ���� ���͸� ������ ������ �Է¹޴´�.
���ڿ� ���ǽĿ��� ���� .equals ���
*/