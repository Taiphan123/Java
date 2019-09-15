package generics;

public class Actor implements Comparable<Actor> {
	private String fistName;
	private String lastName;
	
	
	public Actor(String fistName, String lastName) {
		super();
		this.fistName = fistName;
		this.lastName = lastName;
	}


	public Actor() {
		super();
	}


	public String getFistName() {
		return fistName;
	}


	public void setFistName(String fistName) {
		this.fistName = fistName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public int compareTo(Actor o) {
		return o.fistName.compareTo(this.fistName);
	}
	
}
