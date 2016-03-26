package Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class HashMapDemo {
	
	public static void hashMapTest(){
		//创建map实例
		Map<Integer, String> map = new HashMap<Integer, String>();
		//添加元素
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
//		map.put(1, "e");
		//输出:map没有直接的迭代器，故不能通过增强的for循环或者迭代器输出
		
		//第一种输出方式：通过键值遍历输出
		Set<Integer> keys = map.keySet();//获取键值所组成的set集合
		Iterator<Integer>  iterator = keys.iterator();//返回在此 set 中的元素上进行迭代的迭代器。
		while (iterator.hasNext()) {
			//键值
			Integer key = (Integer) iterator.next();
			System.out.println(key + map.get(key));
		}
		System.out.println("----------------------------------");
		
		//第二种输出方式：直接获取映射的集合
		Set<Entry<Integer, String>> entrys = map.entrySet();//返回此映射中包含的映射关系的 Set 视图。
		for (Entry<Integer, String> entry : entrys) {
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
		
			
   }

	public static void main(String[] args) {
		hashMapTest();

	}

}
