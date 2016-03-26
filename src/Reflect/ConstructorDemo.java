package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class ConstructorDemo {

	public static void main(String[] args) {
		Constructor<Employee> c2 = null;
		//获取Student描述类的一个实例
		Class<Employee> c = Employee.class;
		//获取Student类的所有构造方法
		Constructor<?>[] cs = c.getConstructors();
		for (Constructor<?> constructor : cs) {
			System.out.println("构造方法的修饰符是： " + Modifier.toString(constructor.getModifiers()));
			System.out.println("构造方法的名称，带包名：" + constructor.getName());
			System.out.println("构造方法的名称，不带包名：" + c.getSimpleName());
			Class<?>[] ps = constructor.getParameterTypes();
			for (int i = 0; i < ps.length; i++) {
				System.out.println("第" + (i+1) + "个参数类型是：" + ps[i].getSimpleName());
			}
//			System.out.println(constructor.toString());
		}
		System.out.println("------------");
		//获取带两个形参的构造方法，第一个形参是String类型，第二个形参是int类型，注意接收的是int.class，不是Integer.class
		try {
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
