package sec15.exam01_annotation;

import java.lang.reflect.Method;

public class PrintAnnotationExample {

	public static void main(String[] args) {
		
			Method[] declaredMethods = Service.class.getDeclaredMethods();
			
			for(Method method : declaredMethods) {
					if(method.isAnnotationPresent(PrintAnnotation.class)) {
						PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);
						
						//�޼ҵ� �̸� ���
						System.out.println("[" + method.getName() + "]");
						
						//���м� ���
						for(int i = 0; i<printAnnotation.number(); i++){
							System.out.print(printAnnotation.value());	
						}
						System.out.println();
						
					}
			}
			
	}

}