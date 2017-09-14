import java.util.Map;

public class PhoneNumber {

	private Map <String,String>number;	
	
	public PhoneNumber() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhoneNumber(Map<String,String> number) {
		super();
		this.number = number;
	}

	@Override
	public String toString() {
		return "PhoneNumber [number=" + number + "]";
	}
	
	public void dest() {
		
		System.out.println("Destroyeeee!!");
	}

	public Map<String, String> getNumber() {
		return number;
	}

	public void setNumber(Map<String, String> number) {
		this.number = number;
	}
	
	
	
}
