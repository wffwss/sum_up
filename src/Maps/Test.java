package Maps;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {
		Map<Student, Student> map = new TreeMap<>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// 按照成绩由高到低，姓名由前到后
				if (o1.getScore() == o2.getScore()) {
					//成绩相等，按照姓名由前到后，即自然顺序排列
					return o1.getName().compareTo(o2.getName());
				} else {
					//成绩不等，由高到低排序
					return o2.getScore() - o1.getScore();
				}
			}
		});
		
		//添加元素
		Student s1 = new Student("zhangsan", 90);
		Student s2 = new Student("lisi", 90);
		Student s3 = new Student("wangwu", 100);
		map.put(s1, s1);
		map.put(s2, s2);
		map.put(s3, s3);
		
		Set<Entry<Student, Student>> entrys = map.entrySet();
		Iterator<Entry<Student, Student>> iterator = entrys.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Maps.Student, Maps.Student> entry2 = (Map.Entry<Maps.Student, Maps.Student>) iterator
					.next();
			
	
			System.out.println(entry2.getKey().toString());
		}

	}

}
