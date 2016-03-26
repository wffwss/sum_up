package Tongxin;

public class Test {

	public static void main(String[] args) {
		// 创建一个客人和服务员共同操作的果盘
		Plate plate = new Plate();
		//创建操作上述果盘的客人
		Guest guest = new Guest(plate);
		//创建操作上述果盘的服务员
		Servant servant = new Servant(plate);
		//客人线程
		Thread t1 = new Thread(guest);
		//服务员线程
		Thread t2 = new Thread(servant);
		
		t1.start();
		t2.start();
		

	}

}
