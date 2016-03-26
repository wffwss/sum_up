package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListDemo {

	public static void testQueue() {
		//初步判断：队列可以添加重复元素，同时是有序的
		Queue<Integer> queue = new LinkedList<>();
		// 向队列中插入元素
		queue.offer(1);
		queue.offer(2);
		queue.offer(7);
		queue.offer(0);
		queue.offer(15);
		// 方法一：遍历输出
		for (Integer integer : queue) {
			System.out.println(integer);
		}
		
		//逻辑一，可以使用peek
		while (queue.peek() != null) {
			int number = queue.poll();
			System.out.println(number);
		}
	}

	public static void main(String[] args) {
		testQueue();

	}

}
