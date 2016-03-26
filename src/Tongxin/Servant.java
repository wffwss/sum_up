package Tongxin;

public class Servant implements Runnable {
	Plate plate;
	
	public Servant(Plate plate) {
		super();
		this.plate = plate;
	}

	@Override
	public void run() {
		for (int i = 1; i < 3; i++) {
			//服务员向果盘中加满水果
//			System.out.println("服务员第" + i + "次添加果盘中的水果");
		//	System.out.println(i);
			plate.addFruit(i);
//			System.out.println("      服务员第" + i + "添加完完果盘中的水果");
		}

	}

}
