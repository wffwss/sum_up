package List;

import java.awt.Adjustable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {

	// List��������,liat������ظ�
	public static void listMethods() {
		// ������һ�����϶���
		List<Integer> list = new ArrayList<Integer>();
		// ��
		list.add(1);//����1
		list.add(0);
		list.add(0);
		list.add(8);
		list.add(4, 6);// ����2  ��ʾ������4����ӵ�Ԫ����6
		
		// ���list��Ԫ�ط���һ
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));//�����0086
		}
		System.out.println("---------3-------");
		// ���list��Ԫ�ط���������ǿ��forѭ��
		for (Integer integer2 : list) {
			System.out.println(integer2);
		}
		
		
		System.out.println("---------4-------");
		// ���list��Ԫ�ط�������ʹ�õ�����
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer integer2 = (Integer) iterator.next();
			System.out.println(integer2);
		}
		//���list��Ԫ�ط����ģ�ֱ�����������Student��Ҫ��дtoString��������
		System.out.println(list);
		
	}
	
	public static void main(String[] args) {
		listMethods();
	}
}
