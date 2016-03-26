package Set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
//һ�����set���Ԫ�ض���ʹ����ǿ��forѭ��
public class AllSetDemo {
	//hashset ����
	public static void testHashSet(){
		Set<Integer> set = new HashSet<>();
		set.add(11);
		set.add(44);
		set.add(33);
		set.add(55);
		set.add(8);
		set.add(9);
		//Set���������һ
		for (Integer integer : set) {
			System.out.println(integer);
		}
		System.out.println("----------------------");
		//set�����������������������
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
			
		}
		System.out.println("----------------------");
		
	}
	//linkedhashset ����˳��Ϊ����ʱ��˳��
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
	//treeset        ���򣬸��ݡ�ʵ�ʡ�ֵ��������
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
		//�����TreeSet<Integer>,,,,,,,��ô���� ��set.last()����ȡ���ֵ     
		//System.out.println(set.last());
		
	}
	//�Ƚ���:�ַ����ȽϹ���ǰ��Ⱥ���󣬷�����������ȷ���0��С�ڷ��ظ���
	public static int testString(String s1,String s2){
		return s1.compareTo(s2);
	}
	//treeset+string��TreeSet�������˳��
	public static void testTreeSetString(){
		Set<String> set = new TreeSet<>();
		set.add("zhong");
		set.add("hua");
		set.add("ren");
		set.add("min");
		set.add("gong");
		//��ǿ��forѭ��
	//	for(���� �������������ļ��϶�����)
		for (String string : set) {
			System.out.println(string);
		}
	}
	//��������ַ���,���ڶ���������Ҫ����Comparator�ӿڵİ���
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
