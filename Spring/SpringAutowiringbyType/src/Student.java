public class Student {

	private String name;
	private float gpa;
	private Arrears arrears;
	private PhoneNumber phoneNumber;
	
	
	public Arrears getArrears() {
		return arrears;
	}

	public void setArrears(Arrears arrears) {
		this.arrears = arrears;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, PhoneNumber number) {
		super();
		this.name = name;
		this.phoneNumber = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PhoneNumber getNumber() {
		return phoneNumber;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gpa=" + gpa + "]\n" + phoneNumber + "\nArrears"+arrears;
	}	
	
	
	
	
}
