package Reflect;

public class Test {
	//创建Class类的一个对象通常有三种方法
	public static void main(String[] args) {
		Class<? extends Employee> c1,c2,c3 = null;
		//第一种，通过调用对象的getClass方法获得
		Employee student = new Employee();
		c1 = student.getClass();
		//第二种，通过类名.class，class是所有类都存在的一个静态的隐式常量
		c2 = Employee.class;
		System.out.println("获取类的包名：" + c2.getPackage());
		//第三中，用的最多
		try {
			c3 = (Class<Employee>) Class.forName("Reflect.Employee");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//通过反射来生成对象有如下两种方式
		//第一种使用Class对象的newInstance()方法来创建该Class对象对应类的实例
		//这种方式要求该Class对象的对应类有默认构造器，
		try {
			student=c1.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//第二种方式2.先使用Class对象获取指定的Constructor对象，
		//再调用Constructor对象的newInstance()方法来创建该Class对象对应的实例。

	}

}
