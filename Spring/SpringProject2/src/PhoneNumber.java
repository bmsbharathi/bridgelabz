
public class PhoneNumber {

	String number,code;
	
	public PhoneNumber(String number,String code){
		
		this.code = code;
		this.number = number;
	}

	@Override
	public String toString() {
		return "PhoneNumber [number=" + number + ", code=" + code + "]";
	}
	
	
}
