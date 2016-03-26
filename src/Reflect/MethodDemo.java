package Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		/*Student student = new Student();
		student.getAge();*/
		//假设不知道Student类的构造参数，如何通过反射调用其构造方法呢？
		//第一种，通过反射创建Student的一个实例
		/*Class<Student> c1 = Student.class;
		Student student = null;
		try {
			//保证学生类存在一个无参的构造方法
			student = c1.newInstance();
			student.setAge(20);
			System.out.println(student.getAge());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//获取学生类的所有方法
		Class<Employee> c2 = Employee.class;
		Employee student = c2.newInstance();
		//获取所有的方法，跟权限修饰符无关
		Method[]  ms = c2.getDeclaredMethods();
		/*for (Method method : ms) {
			System.out.println(method);
		}
		System.out.println("-------------------------------");*/
		//获取一个具体的方法
		Method m1 = null ,m2 = null, m3 = null;
		try {
			m1 = c2.getDeclaredMethod("setName", String.class);
			m2 = c2.getDeclaredMethod("getName");

			/*m1.invoke(student, "zhangsan");
			String name =  (String) m2.invoke(student);
			System.out.println(name);*/
			//允许反射调用私有的方法
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}

}
