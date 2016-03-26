package Syn_compare;

public class Test {

	public static void main(String[] args) {
		Account account = new Account("1", 1024);
		
		Person person = new Person(account);
		Thread t1 = new Thread(person);
		Thread t2 = new Thread(person);
		t1.setName("丈夫");
		t2.setName("妻子");
		
		t1.start();
		t2.start();

	}

}
