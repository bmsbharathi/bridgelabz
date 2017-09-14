import java.util.List;

public class Student {

	private String name;
	private List<String> courses;
	private PhoneNumber number;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, List<String> courses) {
		super();
		this.name = name;
		this.courses = courses;
	}
	
	public Student(String name, List<String> courses, PhoneNumber number ) {
		super();
		this.name = name;
		this.courses = courses;
		this.number = number;
	}
	
	public String getName() {
		return name;
	}

	public List<String> getCourses() {
		return courses;
	}

	public PhoneNumber getNumber() {
		return number;
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



	@Override
	public String toString() {
		return "Student [name=" + name + "\ncourses=" + courses + "\n" + number + "\n" +"]";
	}
		
	public void dest() {
			
			System.out.println("Destroy!!");
		}
		
	

	
	
}

