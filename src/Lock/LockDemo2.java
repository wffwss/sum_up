package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Bird2 implements Runnable{
	int number = 10;//本来树上有10只鸟
	int count;//现在树上还有几只鸟
	Lock lock = new ReentrantLock();
	@Override
	public void run() {
		for (int i = 0; i < 6; i++) {//与LockDemo不同的是for循环没有放在里面，就是循环体里面需要一次性执行完，但是
			                         //for并不是一次性执行5次，可能t1执行到i=3，就被t2抢占了，但是一旦进入循环体，
			                         //循环体里的内容会一次性执行完，不会被抢占
			//同步锁若在代码执行期间发生异常，则不会自动释放锁，所以需要在finally中显示释放锁
			lock.lock();//加锁
			try{
				count = number + 1;//加1
				try {
					System.out.println(Thread.currentThread().getName()+",,"+i+",,"+"sleep开始");
					Thread.sleep(100);
					System.out.println("sleep结束");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count = count - 1;//减1
				System.out.println(Thread.currentThread().getName() + ": 当前树上还有" + count + "只鸟");
			} finally {
				lock.unlock();
			}
			
		}
		
	}
	
}

public class LockDemo2 {

	public static void main(String[] args) {
		Bird2 bird = new Bird2();
		Thread t1 = new Thread(bird);
		Thread t2 = new Thread(bird);
		t1.setName("A");
		t2.setName("B");
		t1.start();
		t2.start();
	}

}
