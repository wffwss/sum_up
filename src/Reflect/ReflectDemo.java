package Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;



public class ReflectDemo {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void FiledDemo(){
		
		
		Class<? extends Employee> em=null;
		Employee employee;
		try {
			//创建Class类的一个对象
			em=(Class<? extends Employee>) Class.forName("Reflect.Employee");
			employee=em.newInstance();
			//得到包含某些 Field 对象的数组
			Field[] field=em.getDeclaredFields();
			
		
			System.out.println("获取所有的属性的详细信息");
			for (Field fields : field) {
				System.out.println(fields);
			}
			System.out.println("-------------------------------");
			
			
			System.out.println("获取所有属性名以及对应的属性类型");
			System.out.println("属性\t"+"属性类型\t");
			for (int i = 0; i < field.length; i++) {
				//得到属性名
				String name = field[i].getName();
				//得到属性类型
				String type=field[i].getGenericType().toString();
				System.out.println(name+"\t"+type);
				
			}
			System.out.println("-------------------------------");
			
			System.out.println("获取所有属性的属性值");
			System.out.println("属性名\t"+"属性值\t");
			for (int i = 0; i < field.length; i++) {
				field[i].setAccessible(true);
				//得到属性值
				Object val = field[i].get(employee);
	            System.out.println(field[i].getName() + "\t"+ val);
				
			}
			System.out.println("-------------------------------");
			
			//修改属性值
			for (int i = 0; i < field.length; i++) {
				
				Field f = field[i];
				f.setAccessible(true);
				//得到属性名
				String name = f.getName();
				
				if(name.equals("id")){
					 f.set(employee,"12345"); // 给属性设值
				}
				if(name.equals("name")){
					 f.set(employee,"张风格"); 
				}
				if(name.equals("age")){
					 f.set(employee,18); 
				}
				if(name.equals("sex")){
					 f.set(employee,"男"); 
				}
				if(name.equals("salary")){
					 f.set(employee,4001); 
				}
	           
				
			}
			System.out.println("-------------------------------");
			System.out.println("修改后属性的属性值");
			System.out.println("属性名\t"+"属性值\t");
			for (int i = 0; i < field.length; i++) {
				field[i].setAccessible(true);
				//得到属性值
				Object val = field[i].get(employee);
	            System.out.println(field[i].getName() + "\t"+ val);
				
			}

			
            
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FiledDemo();
	}

}
