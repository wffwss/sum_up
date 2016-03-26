package Syn_compare;

class SocketThread implements Runnable {
	// 同步对象
	Object o1 = new Object();
	Object o2 = new Object();
	@Override
	public void run() {
		if (Thread.currentThread().getName().equals("t1")) {
			synchronized (o1) {
				System.out.println(Thread.currentThread().getName() + "对o1加锁");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println(Thread.currentThread().getName() + "对o2加锁");
				}
			}
			
		} else {
			synchronized (o2) {
				System.out.println(Thread.currentThread().getName() + "对o2加锁");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println(Thread.currentThread().getName() + "对o1加锁");
				}
			}		
		}
	}

}

public class DeadSocketDemo {

	public static void main(String[] args) {
		SocketThread st = new SocketThread();
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}

}
