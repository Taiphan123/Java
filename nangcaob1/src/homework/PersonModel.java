package homework;

import java.util.ArrayList;
import java.util.Collections;

public class PersonModel<T> {
	private ArrayList<T> al = new ArrayList<T>();
	private T obj;
	
	public void addObject(T obj) {
		   al.add(obj);
	}

	public void display() {
		for (T o : al) {
		    System.out.println(o);
		  }
	}
	
	public PersonModel(T obj) {
		this.obj = obj;
	}

	public PersonModel() {

	}

	public T getObj() {
		return obj;
	}

	

	public static void main(String[] args) {
		
		// khoi tao PersonModel<Student>
//		PersonModel<Student> st = new PersonModel<Student>();
//		st.addObject (new Student("AO165122","Phan Tai",20));
//		st.addObject (new Student("AO165170","Phan Huan",22));
		
		
		ArrayList<Student> st = new ArrayList<Student>();
		st.add(new Student("xdasd", "xdasd", 45));
		st.add(new Student("adasd", "adasd", 45));		
		Collections.sort(st);
		for (Student student : st) {
			System.out.println(student);
		}
		//st.display();
		//khoi tao PersonModel<Employee>
		PersonModel<Employee> ep = new PersonModel<Employee>();
		ep.addObject(new Employee("A55483", "Sieu nhan", 10000));
		ep.addObject(new Employee("A55233", "Bat man", 500000));
		ep.display();
		//khoi tao PersonModel<String>
		PersonModel<String> sr = new PersonModel<String>();
		sr.addObject("Ho");
		sr.addObject("Bao");
		sr.display();
		
		
	}

}
