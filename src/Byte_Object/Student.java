package Byte_Object;
import java.io.Serializable;



public class Student  implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	String name;
	int age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student(){
		
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	

}
