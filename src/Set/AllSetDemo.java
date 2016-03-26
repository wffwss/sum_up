package Set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
//一般输出set里的元素都是使用增强的for循环
public class AllSetDemo {
	//hashset 无序，
	public static void testHashSet(){
		Set<Integer> set = new HashSet<>();
		set.add(11);
		set.add(44);
		set.add(33);
		set.add(55);
		set.add(8);
		set.add(9);
		//Set的输出方法一
		for (Integer integer : set) {
			System.out.println(integer);
		}
		System.out.println("----------------------");
		//set的输出方法二，借助迭代器
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
			
		}
		System.out.println("----------------------");
		
	}
	//linkedhashset 有序，顺序为插入时的顺序
	public static void testLinkedHashSet(){
		Set<Integer> set = new LinkedHashSet<>();
		set.add(11);
		set.add(44);
		set.add(33);
		set.add(55);
		set.add(8);
		set.add(9);
		for (Integer integer : set) {
			System.out.println(integer);
		}
	}
	//treeset        有序，根据·实际·值排序（升序）
	public static void testTreeSet(){
		Set<Integer> set = new TreeSet<>();
		set.add(11);
		set.add(44);
		set.add(33);
		set.add(55);
		set.add(8);
		set.add(9);
		
		for (Integer integer : set) {
			System.out.println(integer);
		}
		//如果是TreeSet<Integer>,,,,,,,那么可以 用set.last()来获取最大值     
		//System.out.println(set.last());
		
	}
	//比较器:字符串比较规则：前面比后面大，返回正数，相等返回0，小于返回负数
	public static int testString(String s1,String s2){
		return s1.compareTo(s2);
	}
	//treeset+string，TreeSet本身就有顺序
	public static void testTreeSetString(){
		Set<String> set = new TreeSet<>();
		set.add("zhong");
		set.add("hua");
		set.add("ren");
		set.add("min");
		set.add("gong");
		//增强的for循环
	//	for(类名 对象名：创建的集合对象名)
		for (String string : set) {
			System.out.println(string);
		}
	}
	//降序输出字符串,属于定制排序，需要借助Comparator接口的帮助
	public static void testTreeSetString2(){
		Set<String> set = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		set.add("zhong");
		set.add("hua");
		set.add("ren");
		set.add("min");
		set.add("gong");
		for (String string : set) {
			System.out.println(string);
		}
		
	}
	
	public static void main(String[] args) {
		
		testHashSet();/*
		System.out.println("---------------");
		testLinkedHashSet();
		System.out.println("---------------");*/
	//	testTreeSet();
		
	   // int result = testString("a", "b");
		//System.out.println(result);
		//testTreeSetString2();
		//testTreeSetString();
		
	}

}
