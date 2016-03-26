package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(1);
		//将所有指定元素添加到指定 collection 中，第一个元素表示添加到的集合，第二个参数是可变形参，表示参数的个数是未知不固定的
		Collections.addAll(list, 4,3,0);
		
		System.out.println("排序前" + list);
		Collections.sort(list);
		System.out.println("排序后" + list);
		int index = Collections.binarySearch(list, 2);
		System.out.println("索引值" + index);
		//使用指定元素替换指定列表中的所有元素。
		/*Collections.fill(list, 9);
		System.out.println("替换" + list);*/
		//返回指定 collection 中等于指定对象的元素数
		int count = Collections.frequency(list, 1);
		System.out.println("1出现的次数: " + count);
		//使用另一个值替换列表中出现的所有某一指定值
		Collections.replaceAll(list, 1, 9);
		System.out.println("替换所有元素" + list);
		//反转指定列表中元素的顺序
		Collections.reverse(list);
		System.out.println("逆序输出" + list);
		//随机打乱顺序
		Collections.shuffle(list);
		System.out.println(list);
		//返回指定列表的不可修改视图
		List<Integer> list2 = Collections.unmodifiableList(list);
		list.add(3);
//		list2.add(4);//副本不可以改变，存在运行时异常
		//返回指定列表支持的同步（线程安全的）列表,将一个线程不安全的列表变为线程安全的列表
		List<Integer> list3 = Collections.synchronizedList(list);
		
		
		

	}

}
