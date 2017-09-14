import java.util.Map;

public class PhoneNumber {

	Map <String,String>number;

	
	
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
	
	
	
}
