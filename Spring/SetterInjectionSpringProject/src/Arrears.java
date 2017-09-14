
public class Arrears {

	private String name;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Arrears() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Arrears(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "[Arrear:" + name + "]";
	}
	
	
}
