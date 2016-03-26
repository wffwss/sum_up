package sortSet;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class StudentTest {
	//��ѧ�����ճɼ��ɸߵ��͡�������ǰ��������
	public static void sortStudent(){
		
		//�˷���ֻ����TreeSet�����Ķ���
		Set<Student> set = new TreeSet<>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				//�˷�����Student2Demo���ԭ��һ�������Ի���
				// ���ȳɼ��ɸߵ���
				if (o1.score > o2.score) {
					return -1;
				} else if(o1.score < o2.score){
					return 1;
				} else {
					//�ɼ���ȣ��ٰ���������ǰ��������
					return o1.name.compareTo(o2.name);
				}
				
				
			}
		});
		
		
		
		
		Student s1 = new Student("zhangsan", 90);
		Student s2 = new Student("lisi", 90);
		Student s3 = new Student("wangwu", 100);
		
		set.add(s1);set.add(s2);set.add(s3);
		
		for (Student student : set) {
			System.out.println(student);
		}
		
		
		
		
	}
	
	
	
	

	public static void main(String[] args) {
		sortStudent();
		
	}

}
