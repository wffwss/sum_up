package Set;
//只要两个人的姓名和年龄相同，则认为是同一个人
public class Student {
	String name;
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}


}
