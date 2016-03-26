package Threads;
class MonkeyRunnable implements Runnable {
	String name;
	
	public MonkeyRunnable(String name) {
		super();
		this.name = name;
	}
	
	public void fight(){
		for (int i = 1; i < 11; i++) {
			System.out.println(this.name + "打败了第" + i + "个天兵天将");
		}
	}

	@Override
	public void run() {
		fight();
	}

}
public class RunableDemo {
	public static void main(String[] args) {
		
		MonkeyRunnable m1 = new MonkeyRunnable("第一个小孙悟空");
		MonkeyRunnable m2 = new MonkeyRunnable("第二个小孙悟空");
		MonkeyRunnable m3 = new MonkeyRunnable("第三个小孙悟空");
		//Runnable不是线程，只有一个run方法
		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m2);
		Thread t3 = new Thread(m3);
		t1.start();
		t2.start();
		t3.start();
	}
}
