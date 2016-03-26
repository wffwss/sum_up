package Syn_compare;

public class Person implements Runnable {
	Account account;//多人针对同一张银行卡进行取钱
	
	public Person(Account account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		// 取钱：假设每次取100，直到银行卡余额不足100为止
		for (int i = 0; i < 10; i++) {
			synchronized (account) {
				if (account.getMoney() < 100) {
					System.out.println("余额不足");
					break;
				}
				int money = account.getMoney() - 100;//取完钱之后的余额
				try {
					System.out.println("kaishi");
					Thread.sleep(1000);
					System.out.println("jieshu1");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//	money+=100;
				account.setMoney(money);//及时修改银行卡余额
				System.out.println(Thread.currentThread().getName() + "取走100元，余额还有"
					+ money + "元");
			}
		}
		

	}

}
