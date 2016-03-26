package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Bird implements Runnable{
	
	int num=10;
	int cou;
	Lock lock = new ReentrantLock();
	public void run() {
		lock.lock();//加锁
		try{
			for(int i=0;i<6;i++){
				cou=num+1;
				try {
					System.out.println(Thread.currentThread().getName()+",,"+i+"sleep开始");
					//执行同步方法或同步代码块时，程序调用sleep() yield()来暂停当前线程,不会释放同步监视器的锁定
					Thread.sleep(100);
					System.out.println("sleep结束");//即使睡眠也会接着进行下面的，并没有被其他进程抢占
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cou=cou-1;
				System.out.println(Thread.currentThread().getName() + ": 当前树上还有" + cou+ "只鸟");
				
			}
			
			
		}finally{
			lock.unlock();
		}
		
	}
	
}

public class LockDemo {

	
	public static void main(String[] args) {
		Bird bird=new Bird();
		Thread t1=new Thread(bird);
		Thread t2=new Thread(bird);
		t1.setName("A");
		t2.setName("B");
		t1.start();
		t2.start();

	}

}
