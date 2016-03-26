package Set;

import java.awt.List;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//在set集合中插入元素，要求equals方法返回值和hashcode返回值一致
public class SetDemo {
	//验证set：无序不可重复
	public static void adjust(){
		
		Set<Integer> set = new HashSet<Integer>();
		//添加
		set.add(1);
		set.add(0);
		set.add(0);
		set.add(8);
		set.add(6);
		set.add(null);
		
		//输出
		for (Integer integer : set) {
			System.out.println(integer);
		}
		
		
	} 
	
	//集合存储自定义对象
	public static void test(){
		Student s1 = new Student("张三", 20);
		Student s2 = new Student("张三", 21);
		
		Set<Student> set = new HashSet<Student>();
		set.add(s1);
		set.add(s2);
		
		System.out.println(set);//因为Student中重写了toString（）方法，所以可以直接输出set。
		//                        另外，如果是Set<Integer>,则可以不写toString（）
		
		
	}
	
	
	public static void main(String[] args) {
//		adjust();
		test();
	}

}
