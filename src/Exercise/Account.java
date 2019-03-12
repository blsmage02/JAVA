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
상수(static final) : 상수 = 정적 final 필드 
상수 이름 : 전부 대문자로 작성하는 것이 관례 , 다른 단어가 결합되면 _ 로 연결하는 것이 관례 

Getter(읽기 전용 필드가 있을 수 있다) 

private 필드의 값을 리턴하는 역할을 한다. 

getFieldName 또는 isFieldName 메소드를 말한다.(필드 타입이 boolean일 경우 is로 시작) 


Setter(외부에서 엉뚱한 값으로 변경할 수 없도록 한다.) 

외부에서 주어진 값을 필드 값으로 수정한다.(필요할 경우 외부의 값을 유효성을 검사한다.) 

setFieldName(타입 변수) 메소드를 말한다.(매개 변수 타입은 필드의 타입과 동일) 

*/