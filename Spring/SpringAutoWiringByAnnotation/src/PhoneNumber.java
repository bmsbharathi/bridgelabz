
public class PhoneNumber {

	private String code,number;

	
	
	public PhoneNumber() {
		super();
		System.out.println("Inside PhoneNumber");
	}

	PhoneNumber(String code,String number){
		
		this.code = code;
		this.number = number;
	}
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}

	public String getNumber() {
		return number;
	}

	
	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "PhoneNumber [code=" + code + ", number=" + number + "]";
	}
	
	void print() {
		System.out.println("Printing.."+number);
	}
	
	
}
