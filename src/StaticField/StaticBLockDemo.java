package StaticField;
//当前代码的执行顺序：初始化先执行，后执行main主函数中的代码
/**
 * @author mhdong
 * 不管是哪步，都是按照代码在程序中的先后顺序执行的
 *第一步：执行的应该是类加载中的连接步骤，为类的静态Field分配内存，简单来说知道了存在如下的静态整型变量，a,c,b;
 *第二步：执行的应该是类加载中的连接步骤，设置静态Field默认初始值，即a= 0,c=0,b=0
 *第三步：执行的应该是类加载中的初始化步骤，a=5,c=0,b=6,b=9
 */
public class StaticBLockDemo {
	//编译期只给类成员变量分配内存和初始化，实例成员变量需要在运行期分配内存并初始化
	int d;//运行后初始化
	static int a = 5;//运行前初始化
	static int c;
	//静态初始化块
	static {
		int d = 10;//局部变量
		b = 6;
		System.out.println("-----");
	}
	public static void main(String[] args) {
		System.out.println(StaticBLockDemo.b);
	}
	static int b = 9;
}
