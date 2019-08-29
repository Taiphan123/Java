
public class Student {
	String name;
	int rollNo;
	static String collegeName;
	static int counter = 0;
	
	public Student (String name, int rollNo) {
		this.name = name;
		this.rollNo= rollNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public static String getCollegeName() {
		return collegeName;
	}
	public static void setCollegeName(String collegeName) {
		Student.collegeName = collegeName;
	}
	public static int setRollNo() {
		counter ++;
		return counter;
	}
	public static void setCounter(int counter) {
		Student.counter = counter;
	}
	
	void getSutdentInfor()
	{
		System.out.println("name"+this.name);
		System.out.println("rollNo"+this.rollNo);
		System.out.println("CollegeName"+ collegeName);
	}
	
}
