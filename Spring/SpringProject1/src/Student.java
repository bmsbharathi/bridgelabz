public class Student {

	private String name;
	private int age;
	private float gpa;
	
	public int getAge() {
		return age;
	}
	public float getGpa() {
		return gpa;
	}
	public String getName() {
		return name;
	}
	
	
	public void setAge(int age) {
		this.age = age;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gpa=" + gpa + "]";
	}
	
	
	
}
