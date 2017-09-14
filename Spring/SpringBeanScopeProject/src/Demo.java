import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
		
		Student stud = (Student)context.getBean("studentBean");
		System.out.println(stud);
		
		stud.setName("Kevin");
		stud.setGpa(9);

		Student stude = (Student)context.getBean("studentBean");
		System.out.println(stude);

		Student stud1 = (Student)context.getBean("studentBean1");
		stud1.setName("Aniketh");
		System.out.println(stud1.getName());
		
		
		
		Student stud2 = (Student)context.getBean("studentBean1");
		System.out.println(stud2.getName());

		
	}

	
}
