package Exercise;

public class Exercise04 {

	public static void main(String[] args) {
		
		boolean n = true;
		
		while(n)
		{
			int dice1 = (int)(Math.random()*6)+1;
			int dice2 = (int)(Math.random()*6)+1;
			
			if(dice1+dice2 != 5)
			{
				System.out.println("("+dice1 + ","+dice2+")");
			}
			else if(dice1+dice2 == 5)
				break;
			
		}
			
		

	}

}

/*
 * while���� Math.radom()�޼ҵ带 �̿��ؼ� �� ���� �ֻ����� ������ �� ������ ���� (��1, ��2)���·� ����ϰ�,
 * ���� ���� 5�� �ƴϸ� ��� �ֻ����� ������, ���� ���� 5�̸� ������ ���ߴ� �ڵ带 �ۼ��غ�����.
 * ���� ���� 5�� �Ǵ� ������ (1,4), (4,1), (2,3), (3,2)
*/