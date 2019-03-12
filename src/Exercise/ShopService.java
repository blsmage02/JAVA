package Exercise;

public class ShopService {
	
		private static ShopService singleton = new ShopService();
		
		private ShopService() {}
		
		public static ShopService getInstance()
		{
			return singleton;
		}

}

/*
싱글톤을 만드는 방법 

자신의 타입으로 정적필드를 선언하고, 자신의 객체를 생성해 초기화한다. 

private로 자신의 생성자 생성 

외부에서 호출할 수 있는 정적 메소드인 getInstance()를 선언한다. 

정적 필드에서 참조하고 있는 자신의 객체를 리턴 하도록 한다. 
*/
