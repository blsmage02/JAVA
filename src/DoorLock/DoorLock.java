package DoorLock;

public class DoorLock {

	static int[] myPassword = new int[8];			//���� ���� �����ȣ �迭
	static int[] inputPassword = new int[8];		//�Է��� �� �ӽ÷� ���� �迭

	public static void main(String[] args) {

		Frame frame = new Frame();

		boolean run = true;

		while(run) {
			int count;

			for(count = 0; count < myPassword.length; count++) {}

			if(count < 3 && count > 9) { 
				System.out.println("��й�ȣ�� 4�̻� 8������ ���ڸ� �Է����ּ���.");
				run = false;
			}

		}	

	}

	

}
