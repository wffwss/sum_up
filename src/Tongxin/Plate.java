package Tongxin;

public class Plate {
	// 果盘最多有三个水果，服务员一次性添加MAX个水果
	private static final int MAX = 3;
	// 果盘当前水果剩余数量
	private int count;

	// 客人取用水果：一次取用一个
	public synchronized void getFruit(int i) {
		while (count == 0) {
			//通知服务员
			notifyAll();
			System.out.println("此时循环体i="+i+"，客人发现果盘中没有水果，客人等待并通知服务员添加水果");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		count--;
		System.out.println("此时循环体i="+i+"，客户取用了一个水果，还剩" + count + "个水果");

	}

	// 服务员添加水果，一次性加满
	public synchronized void addFruit(int i) {

		while (count > 0) {
			System.out.println("服务员发现果盘中还有水果，服务员等待并通知客人继续食用，不必添加水果");
			try {
				wait();//释放锁，并等待通知继续往下执行
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		count = MAX;
		System.out.println("服务员第"+i+"次把果盘加满，通知客人过来食用");
		
		//此处表示服务员添加满了水果，通知客人过来食用
		notifyAll();

	}
}
