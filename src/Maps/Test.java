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
				// ���ճɼ��ɸߵ��ͣ�������ǰ����
				if (o1.getScore() == o2.getScore()) {
					//�ɼ���ȣ�����������ǰ���󣬼���Ȼ˳������
					return o1.getName().compareTo(o2.getName());
				} else {
					//�ɼ����ȣ��ɸߵ�������
					return o2.getScore() - o1.getScore();
				}
			}
		});
		
		//���Ԫ��
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
