package Exercise;

public class Exercise03 {

	public static void main(String[] args) {
		
		int n;
		int result = 0;
		
		for(n=1;n<=100;n++)
		{
			if(n%3==0)result+=n;
		}
		
		System.out.println("3의 배수의 합 : " + result);

	}

}
//for문을 이용해서 1부터 100까지의 정수 중에서 3의 배수의 총합을 구하는 코드를 작성하세요.
