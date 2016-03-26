package List;

import java.awt.Adjustable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {

	// List常见方法,liat有序可重复
	public static void listMethods() {
		// 创建了一个集合对象
		List<Integer> list = new ArrayList<Integer>();
		// 增
		list.add(1);//方法1
		list.add(0);
		list.add(0);
		list.add(8);
		list.add(4, 6);// 方法2  表示在索引4处添加的元素是6
		
		// 输出list中元素方法一
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));//结果是0086
		}
		System.out.println("---------3-------");
		// 输出list中元素方法二：增强的for循环
		for (Integer integer2 : list) {
			System.out.println(integer2);
		}
		
		
		System.out.println("---------4-------");
		// 输出list中元素方法三：使用迭代器
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer integer2 = (Integer) iterator.next();
			System.out.println(integer2);
		}
		//输出list中元素方法四：直接输出，但是Student里要改写toString（）方法
		System.out.println(list);
		
	}
	
	public static void main(String[] args) {
		listMethods();
	}
}
