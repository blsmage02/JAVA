package sec08.exam04_overloading;

public class CalculatorExample {

	public static void main(String[] args) {
		
		Calculator myCalu = new Calculator();
		
		double result1 = myCalu.areaRectangle(10);
		double result2 = myCalu.areaRectangle(10, 20);
		
		System.out.println("���簢���� ���� = " + result1 );
		System.out.println("���簡���� ���� = " + result2);

	}

}
