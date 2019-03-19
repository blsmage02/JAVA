package sec04.exam03_compare;

public class StringEqualsExample {

	public static void main(String[] args) {
		
		String strVar1 = "신용권";
		String strVar2 = "신용권";
		String strVar3 = new String("신용권");
		
		System.out.println(strVar1 == strVar2);
		System.out.println(strVar1 == strVar3);
		System.out.println();
		System.out.println(strVar1.equals(strVar2));
		System.out.println(strVar1.equals(strVar3));
	}

}
