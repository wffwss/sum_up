package Threads;

class StopThread extends Thread{
	int flag;	
	public StopThread(int flag) {
		super();
		this.flag = flag;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			if (i== flag) {
				break;
			}
		}
	}
}

class StopThread2 extends Thread{
	private boolean flag = true;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		while (isFlag()) {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
				if (isFlag()) {
					break;
				}
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			setFlag(false);
		}
	}
}

public class StopDemo {

	public static void main(String[] args) {
		StopThread2 stopThread = new StopThread2();
		stopThread.start();
		//外界触发停止条件
		/*try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		for (int i = 0; i < 10; i++) {
			System.out.println("------------");
		}
		stopThread.setFlag(false);
		
		System.out.println("子线程已经停止");

	}

}
