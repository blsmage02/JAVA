package sec10.exam04_singleton;

public class Singleton {
	
		private static Singleton singleton = new Singleton();
	
		private Singleton() {}	//private ����ؼ� new �����ڷ� �ܺο��� ȣ�� �Ұ�
		
		static Singleton getInstance() {
			return singleton;
		}
}
