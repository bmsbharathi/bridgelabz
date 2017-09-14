
public class Person {

	private String name,city;
	private int age;
	private PhoneNumber number;
	
	public Person(String name,String city,int age,PhoneNumber number) {
		
		this.name = name;
		this.city = city;
		this.age = age;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", city=" + city + ", age=" + age + " Number= "+number+" ]";
	}
	
	
}

