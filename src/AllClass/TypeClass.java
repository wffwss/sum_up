package AllClass;
class Hello{
	int out_x = 0;

	public void method() {
		Inner1 inner1 = new Inner1();
		
		class Inner2 // 在方法体内部定义的内部类，不能有修饰符
		{
			public void method() {
				out_x = 3;
			}
		}
		Inner2 inner2 = new Inner2();
	}

	public class Inner1 // 在方法体外面定义的内部类,4种修饰符都可以
	{
	}

	public static void main(String[] args) {

	}
	
}

public  class TypeClass {

	int out_x = 0;

	public void method() {
		Inner1 inner1 = new Inner1();
		
		class Inner2 // 在方法体内部定义的内部类，不能有修饰符
		{
			public void method() {
				out_x = 3;
			}
		}
		Inner2 inner2 = new Inner2();
	}

	public class Inner1 // 在方法体外面定义的内部类,4种修饰符都可以
	{
	}

	public static void main(String[] args) {

	}

}
