package Threads;


class PriorityThread extends Thread{
	public void run() {
		System.out.println("线程优先级" + getPriority());
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + ": " + i);
		}
	};
}

public class PriorityDemo {
	//java在设置线程优先级的时候，优先级高的线程先运行，但是实际开发中取决于系统的线程优先级设置，例如，linux系统所有线程的优先级相同
	public static void main(String[] args) {
		/*System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);*/
		//默认情况下，线程的优先级是5，NORM_PRIORITY
		System.out.println(Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		
		//在线程中创建一个新线程，新线程的优先级默认采用当前线程的优先级
		PriorityThread p1 = new PriorityThread();
		p1.setPriority(Thread.MIN_PRIORITY);
		p1.start();
		
		PriorityThread p2 = new PriorityThread();
		p2.setPriority(Thread.NORM_PRIORITY);
		p2.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
		
	}

}
