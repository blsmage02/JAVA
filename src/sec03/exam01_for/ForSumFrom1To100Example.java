package sec03.exam01_for;

public class ForSumFrom1To100Example {

	public static void main(String[] args) {
		
			int sum=0;
			int i;
			
			for( i=1;i<=100;i++)
			{
				sum+=i;
			}
			
			System.out.println("1부터"+ (i-1) +"까지의 합 : "+sum);
	}

}
