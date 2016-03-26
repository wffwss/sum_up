package Threads;
class YieldThread extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			yield();//暂时放弃cpu的使用权，重新转入就绪状态，和其他线程一起抢占CPU的使用权
			System.out.println(getName() + ": " + i);
		}
	}
}
public class YieldDemo {

	public static void main(String[] args) {
		
		YieldThread yieldThread = new YieldThread();
		yieldThread.setName("yield线程");
		yieldThread.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}

	}

}
