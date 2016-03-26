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
	//此方法只能是TreeSet声明的对象
	@Override
	public int compareTo(Student2Demo o) {
		// 比较的对象是当前对象和形参中的。
		//成绩由高到低、姓名由前到后
		if (this.score == o.score) {//成绩相等，自然顺序
			return this.name.compareTo(o.name);
		} else {
			//成绩不等，需要由高到底排列，前面的成绩大于后面的成绩，返回负数，前面的成绩小于后面的成绩，返回正数
			return o.score - this.score;
		}
	}
	public static void sortStudent2(){
		//测试Student2里面的 ,基本的Set<student>
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
