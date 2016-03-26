package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListDemo {

	public static void testQueue() {
		//�����жϣ����п�������ظ�Ԫ�أ�ͬʱ�������
		Queue<Integer> queue = new LinkedList<>();
		// ������в���Ԫ��
		queue.offer(1);
		queue.offer(2);
		queue.offer(7);
		queue.offer(0);
		queue.offer(15);
		// ����һ���������
		for (Integer integer : queue) {
			System.out.println(integer);
		}
		
		//�߼�һ������ʹ��peek
		while (queue.peek() != null) {
			int number = queue.poll();
			System.out.println(number);
		}
	}

	public static void main(String[] args) {
		testQueue();

	}

}
