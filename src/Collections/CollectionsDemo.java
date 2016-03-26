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
		//������ָ��Ԫ����ӵ�ָ�� collection �У���һ��Ԫ�ر�ʾ��ӵ��ļ��ϣ��ڶ��������ǿɱ��βΣ���ʾ�����ĸ�����δ֪���̶���
		Collections.addAll(list, 4,3,0);
		
		System.out.println("����ǰ" + list);
		Collections.sort(list);
		System.out.println("�����" + list);
		int index = Collections.binarySearch(list, 2);
		System.out.println("����ֵ" + index);
		//ʹ��ָ��Ԫ���滻ָ���б��е�����Ԫ�ء�
		/*Collections.fill(list, 9);
		System.out.println("�滻" + list);*/
		//����ָ�� collection �е���ָ�������Ԫ����
		int count = Collections.frequency(list, 1);
		System.out.println("1���ֵĴ���: " + count);
		//ʹ����һ��ֵ�滻�б��г��ֵ�����ĳһָ��ֵ
		Collections.replaceAll(list, 1, 9);
		System.out.println("�滻����Ԫ��" + list);
		//��תָ���б���Ԫ�ص�˳��
		Collections.reverse(list);
		System.out.println("�������" + list);
		//�������˳��
		Collections.shuffle(list);
		System.out.println(list);
		//����ָ���б�Ĳ����޸���ͼ
		List<Integer> list2 = Collections.unmodifiableList(list);
		list.add(3);
//		list2.add(4);//���������Ըı䣬��������ʱ�쳣
		//����ָ���б�֧�ֵ�ͬ�����̰߳�ȫ�ģ��б�,��һ���̲߳���ȫ���б��Ϊ�̰߳�ȫ���б�
		List<Integer> list3 = Collections.synchronizedList(list);
		
		
		

	}

}
