package Exercise;

public class Exercise03 {

	public static void main(String[] args) {
		
		int n;
		int result = 0;
		
		for(n=1;n<=100;n++)
		{
			if(n%3==0)result+=n;
		}
		
		System.out.println("3�� ����� �� : " + result);

	}

}
//for���� �̿��ؼ� 1���� 100������ ���� �߿��� 3�� ����� ������ ���ϴ� �ڵ带 �ۼ��ϼ���.
