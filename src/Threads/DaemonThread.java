package Threads;

class MyDaemo extends Thread{
	@Override
	public void run() {
		for (int i = 1; i < 51; i++) {
			System.out.println(getName() + ": " + i);
		}
	}
}

public class DaemonThread {

	public static void main(String[] args) {
		System.out.println("enter main");
		
		MyDaemo myDaemo = new MyDaemo();
		myDaemo.setName("守护线程");
		myDaemo.setDaemon(true);
		//当前台进程结束之后，守护线程也会结束
		myDaemo.start();
		
		for (int i = 1; i < 21; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
		
		System.out.println("exit main");

	}

}
