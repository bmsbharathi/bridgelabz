import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		
		Student one = (Student) context.getBean("personBean");
		System.out.println(""+one);

		
		context.close();
	}

}
