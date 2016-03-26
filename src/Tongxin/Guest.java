package Tongxin;

public class Guest implements Runnable {
	Plate plate;

	public Guest(Plate plate) {
		super();
		this.plate = plate;
	}


	@Override
	public void run() {
		for (int i = 1; i < 6; i++) {
			//客人一次取一个水果
//			System.out.println("客人第" + i + "次取用果盘中的水果");
			plate.getFruit(i);
//			System.out.println("     客人第" + i + "次取完果盘中的水果");
		}

	}

}
