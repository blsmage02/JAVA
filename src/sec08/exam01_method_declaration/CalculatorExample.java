package sec08.exam01_method_declaration;

public class CalculatorExample {

	public static void main(String[] args) {
		
		
		Calculator myCale = new Calculator();
		myCale.powerOn();
		
		int result1 = myCale.plus(10,20);
		System.out.println(result1);
		
		byte x = 10, y = 4;
		double result2 = myCale.divide(x, y);
		System.out.println(result2);

	}

}
