package Syn_compare;
//银行卡，有卡号和余额两个属性
public class Account {
	
	private String id;
	private int money;
	
	public Account(String id, int money) {
		super();
		this.id = id;
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	

}
