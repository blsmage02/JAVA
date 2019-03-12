package sec09.exam01_instance_member;

public class Car {
	
		String model;
		int speed;
		
		Car(String model)
		{
			this.model = model;
		}
		
		void setSpped(int speed)
		{
			this.speed = speed;
		}
		
		void run()
		{
			for(int i = 10; i <= 50; i+=10)
					{
						this.setSpped(i);
						System.out.println(this.model + "가 달립니다.(시속 : " + speed + "km/h)");
					}
		}

}
