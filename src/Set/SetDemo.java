package Set;

import java.awt.List;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//��set�����в���Ԫ�أ�Ҫ��equals��������ֵ��hashcode����ֵһ��
public class SetDemo {
	//��֤set�����򲻿��ظ�
	public static void adjust(){
		
		Set<Integer> set = new HashSet<Integer>();
		//���
		set.add(1);
		set.add(0);
		set.add(0);
		set.add(8);
		set.add(6);
		set.add(null);
		
		//���
		for (Integer integer : set) {
			System.out.println(integer);
		}
		
		
	} 
	
	//���ϴ洢�Զ������
	public static void test(){
		Student s1 = new Student("����", 20);
		Student s2 = new Student("����", 21);
		
		Set<Student> set = new HashSet<Student>();
		set.add(s1);
		set.add(s2);
		
		System.out.println(set);//��ΪStudent����д��toString�������������Կ���ֱ�����set��
		//                        ���⣬�����Set<Integer>,����Բ�дtoString����
		
		
	}
	
	
	public static void main(String[] args) {
//		adjust();
		test();
	}

}
