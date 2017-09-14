import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
		
		Student stud = (Student)context.getBean("studentBean");
		System.out.println(stud);


		context.registerShutdownHook();
	}

	
}
