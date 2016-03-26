package Threads;

class SleepThread extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				//运行中的线程调用sleep方法后由运行状态转为阻塞状态
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
}


public class SleepDemo {

	public static void main(String[] args) {
		SleepThread sleepThread = new SleepThread();
		sleepThread.start();

	}

}
