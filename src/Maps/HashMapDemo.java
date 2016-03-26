package Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class HashMapDemo {
	
	public static void hashMapTest(){
		//����mapʵ��
		Map<Integer, String> map = new HashMap<Integer, String>();
		//���Ԫ��
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
//		map.put(1, "e");
		//���:mapû��ֱ�ӵĵ��������ʲ���ͨ����ǿ��forѭ�����ߵ��������
		
		//��һ�������ʽ��ͨ����ֵ�������
		Set<Integer> keys = map.keySet();//��ȡ��ֵ����ɵ�set����
		Iterator<Integer>  iterator = keys.iterator();//�����ڴ� set �е�Ԫ���Ͻ��е����ĵ�������
		while (iterator.hasNext()) {
			//��ֵ
			Integer key = (Integer) iterator.next();
			System.out.println(key + map.get(key));
		}
		System.out.println("----------------------------------");
		
		//�ڶ��������ʽ��ֱ�ӻ�ȡӳ��ļ���
		Set<Entry<Integer, String>> entrys = map.entrySet();//���ش�ӳ���а�����ӳ���ϵ�� Set ��ͼ��
		for (Entry<Integer, String> entry : entrys) {
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
		
			
   }

	public static void main(String[] args) {
		hashMapTest();

	}

}
