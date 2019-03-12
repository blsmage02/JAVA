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
�̱����� ����� ��� 

�ڽ��� Ÿ������ �����ʵ带 �����ϰ�, �ڽ��� ��ü�� ������ �ʱ�ȭ�Ѵ�. 

private�� �ڽ��� ������ ���� 

�ܺο��� ȣ���� �� �ִ� ���� �޼ҵ��� getInstance()�� �����Ѵ�. 

���� �ʵ忡�� �����ϰ� �ִ� �ڽ��� ��ü�� ���� �ϵ��� �Ѵ�. 
*/
