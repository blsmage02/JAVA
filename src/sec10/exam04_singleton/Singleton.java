package sec10.exam04_singleton;

public class Singleton {
	
		private static Singleton singleton = new Singleton();
	
		private Singleton() {}	//private 사용해서 new 연산자로 외부에서 호출 불가
		
		static Singleton getInstance() {
			return singleton;
		}
}
