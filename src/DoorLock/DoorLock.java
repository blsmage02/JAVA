package DoorLock;

public class DoorLock {

	static int[] myPassword = new int[8];			//내가 가질 비빌번호 배열
	static int[] inputPassword = new int[8];		//입력한 값 임시로 갖는 배열

	public static void main(String[] args) {

		Frame frame = new Frame();

		boolean run = true;

		while(run) {
			int count;

			for(count = 0; count < myPassword.length; count++) {}

			if(count < 3 && count > 9) { 
				System.out.println("비밀번호는 4이상 8이하의 숫자를 입력해주세요.");
				run = false;
			}

		}	

	}

	

}
