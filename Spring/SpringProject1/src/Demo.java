import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
		
		Student stud = (Student)context.getBean("studentBean");
		System.out.println(stud);

		Student stude = (Student)context.getBean("studentBean1");
		System.out.println(stude);

	}
}
