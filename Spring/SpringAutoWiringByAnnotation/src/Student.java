import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class Student {

	private String name;
	private double gpa;
	/*private Arrears arrears;*/
	private PhoneNumber phoneNumber;
	
 	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	@Autowired
	@Qualifier("dependent Student")
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getName() {
		return name;
	}


	public double getGpa() {
		return gpa;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", gpa=" + gpa + ", phoneNumber=" + phoneNumber + "]";
	}

	public void print() {
		phoneNumber.print();
	}
	
}