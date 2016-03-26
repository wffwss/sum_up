package sortSet;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Student2Demo  implements Comparable<Student2Demo>{
	String name;
	int score;
	
	public Student2Demo(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	//�˷���ֻ����TreeSet�����Ķ���
	@Override
	public int compareTo(Student2Demo o) {
		// �ȽϵĶ����ǵ�ǰ������β��еġ�
		//�ɼ��ɸߵ��͡�������ǰ����
		if (this.score == o.score) {//�ɼ���ȣ���Ȼ˳��
			return this.name.compareTo(o.name);
		} else {
			//�ɼ����ȣ���Ҫ�ɸߵ������У�ǰ��ĳɼ����ں���ĳɼ������ظ�����ǰ��ĳɼ�С�ں���ĳɼ�����������
			return o.score - this.score;
		}
	}
	public static void sortStudent2(){
		//����Student2����� ,������Set<student>
		Set<Student2Demo> set = new TreeSet<>();
		Student2Demo s1= new Student2Demo("zhangsan", 90);
		Student2Demo s2 = new Student2Demo("lisi", 90);
		Student2Demo s3 = new Student2Demo("wangwu", 100);
		
		set.add(s1);set.add(s2);set.add(s3);
		
		for (Student2Demo student : set) {
			System.out.println(student);
		}	
		
	}

	@Override
	public String toString() {
		
		return "Student2 [name=" + name + ", score=" + score + "]";
	}
	public static void main(String[] args) {
		
        sortStudent2();
	}
	

}
