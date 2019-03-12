package sec08.exam01_method_declaration;

public class Computer {
	
	int sum1(int[] values)
	{
		int sum = 0;
		for(int i = 0; i<values.length;i++)
		{
			sum += values[i];
		}
		return sum;
	}
	
	int sum2(int ... values)
	{
		int sum = 0;
		for(int i = 0; i<values.length;i++)
		{
			sum += values[i];
		}
		return sum;
	}

}

/*
메소드 매개변수를 배열로 생성시
(int[] values) or (int ... values) 같은 뜻임
배열에 넣을 값이 정해지지 않았을때
*/