package Exercise;

public class Account {
	
		public static final int MIN_BALANCE = 0;
		public static final int MAX_BALANCE = 1000000;
		
		private int balance;
		
		public int getBalance()
		{
			return balance;
		}
		
		public void setBalance(int balance)
		{
			if(balance < Account.MIN_BALANCE || balance > Account.MAX_BALANCE)
			{
				return ;
			}
			
			this.balance = balance;
		}

}
/*
���(static final) : ��� = ���� final �ʵ� 
��� �̸� : ���� �빮�ڷ� �ۼ��ϴ� ���� ���� , �ٸ� �ܾ ���յǸ� _ �� �����ϴ� ���� ���� 

Getter(�б� ���� �ʵ尡 ���� �� �ִ�) 

private �ʵ��� ���� �����ϴ� ������ �Ѵ�. 

getFieldName �Ǵ� isFieldName �޼ҵ带 ���Ѵ�.(�ʵ� Ÿ���� boolean�� ��� is�� ����) 


Setter(�ܺο��� ������ ������ ������ �� ������ �Ѵ�.) 

�ܺο��� �־��� ���� �ʵ� ������ �����Ѵ�.(�ʿ��� ��� �ܺ��� ���� ��ȿ���� �˻��Ѵ�.) 

setFieldName(Ÿ�� ����) �޼ҵ带 ���Ѵ�.(�Ű� ���� Ÿ���� �ʵ��� Ÿ�԰� ����) 

*/