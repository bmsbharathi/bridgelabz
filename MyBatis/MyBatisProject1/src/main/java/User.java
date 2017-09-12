

public class User {
	
	String email,uname,education,gender;
	int age,id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	@Override
	public String toString() {
		return "User [email=" + email + ", uname=" + uname + ", education=" + education + ", gender=" + gender
				+ ", age=" + age + "]";
	}
}
