import java.util.List;
import java.util.Set;

public class Student {

	private String name;
	private List<String> courses;
	private PhoneNumber number;
	private Set<Arrears> arrears;
	
	public Student(String name, List<String> courses, PhoneNumber number, Set<Arrears> arrears) {
		super();
		this.name = name;
		this.courses = courses;
		this.number = number;
		this.arrears = arrears;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "\ncourses=" + courses + "\n" + number + "\n" + arrears + "]";
	}
		
	public void dest() {
			
			System.out.println("Destroy!!");
		}
		
	

	
	
}

