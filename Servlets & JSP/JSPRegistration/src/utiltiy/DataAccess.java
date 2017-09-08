package utiltiy;

public class DataAccess {
	
	String email,uname,education,gender;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	int age;

	public String getUname() {
		return uname;
	}

	public String getEducation() {
		return education;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
