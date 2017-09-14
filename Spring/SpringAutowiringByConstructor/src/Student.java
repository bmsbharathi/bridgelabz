public class Student {

	private String name;
	private double gpa;
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


	public Student(String name, double gpa, Arrears arrears, PhoneNumber phoneNumber) {
		super();
		this.name = name;
		this.gpa = gpa;
		this.arrears = arrears;
		this.phoneNumber = phoneNumber;
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

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gpa=" + gpa + "]\n" + phoneNumber +"\n"+arrears;
	}	
	
	
	
	
}
