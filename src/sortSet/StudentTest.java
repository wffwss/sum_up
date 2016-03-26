package sortSet;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class StudentTest {
	//对学生按照成绩由高到低、姓名由前到后排序
	public static void sortStudent(){
		
		//此方法只能是TreeSet声明的对象
		Set<Student> set = new TreeSet<>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				//此方法与Student2Demo里的原理一样，可以互用
				// 首先成绩由高到低
				if (o1.score > o2.score) {
					return -1;
				} else if(o1.score < o2.score){
					return 1;
				} else {
					//成绩相等，再按照姓名由前到后排列
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
