import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
		Student stude1 = (Student) context.getBean("stud1");	
		System.out.println(stude1);
	
		/*
		Arrears ar = (Arrears)context.getBean("arrears");
		System.out.println(ar);*/
	}
}
