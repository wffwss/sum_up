package Threads;

class JoinThread extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + ": " + i);
		}
	}
}

public class JoinDemo {

	public static void main(String[] args) {
		System.out.println("enter main");
		
		JoinThread jt1 = new JoinThread();
		JoinThread jt2 = new JoinThread();
		jt1.setName("线程一");
		jt2.setName("线程二");
		jt1.start();
		//jt2.start();
		try {
			//当在A线程中调用了B线程的join方法，则必须等待B线程执行完成之后，才可以继续执行A线程，其他线程不受影响
			//必须在调用start方法之后才可以调用join方法
			//线程在运行状态下调用join方法转到阻塞状态
			jt1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}

}
