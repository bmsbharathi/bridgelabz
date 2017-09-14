import java.util.List;
import java.util.Set;

public class Student {

	private String name;
	private List<String> courses;
	private PhoneNumber number;
	private Set<Arrears> arrears;
	
	public String getName() {
		return name;
	}

	public List<String> getCourses() {
		return courses;
	}

	public PhoneNumber getNumber() {
		return number;
	}

	public Set<Arrears> getArrears() {
		return arrears;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	public void setNumber(PhoneNumber number) {
		this.number = number;
	}

	public void setArrears(Set<Arrears> arrears) {
		this.arrears = arrears;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

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

