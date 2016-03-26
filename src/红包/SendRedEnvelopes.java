package 红包;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SendRedEnvelopes {
	public static int remainder = 4;// 红包剩余个数
	public static int number = 4;// 红包总个数
	public static int money = 10;// 红包总钱数
	public static int persion=-1;//用来标识是第几个抢红包的客户，有的客户进来的早却不一定抢
	public static List<Socket> socketPool = new ArrayList<>();
	public static double[]  gMoney = new double[number];//存放生成的红包
	// 生成红包,保存在gMoney[]数组
	public static void getMoney() {

		Random r = new Random();
		DecimalFormat format = new DecimalFormat(".##");

		double middle = Double.parseDouble(format.format(money / number));

		double redMoney = 0;
		double nextMoney = money;
		double sum = 0;
		int index = 0;
		for (int i = number; i > 0; i--) {
			if (i == 1) {
				gMoney[index] = nextMoney;
			} else {
				while (true) {
					String str = format.format(r.nextDouble() * nextMoney);
					redMoney = Double.parseDouble(str);
					if (redMoney > 0 && redMoney < middle) {
						break;
					}
				}
				nextMoney = Double.parseDouble(format.format(nextMoney
						- redMoney));
				sum = sum + redMoney;
				gMoney[index] = redMoney;
				middle = Double.parseDouble(format.format(nextMoney / (i - 1)));
				index++;
			}
		}
	}

	public static void main(String[] args) {
		try {
			//生成红包
			getMoney();
			
			ServerSocket server = new ServerSocket(12241);
			
			int count = 0;
			System.out.println("***服务器即将启动，等待客户端的链接***");
			while (true) {

				Socket client = server.accept();// 侦听并接受到此套接字的连接。
				System.out.println("有客户连接");
				// 每接收到一个连接，就将请求连接的客户端socket加入socket池
				socketPool.add(client);
				new Thread(new SendThread(client)).start();
				PrintStream writer = new PrintStream(client.getOutputStream());
				// 进行普通IO操作
				writer.println("红包口令【y】");
		        writer.flush();
				count++; // 统计客户端的数量
				System.out.println("客户端的数量: " + count);
				InetAddress address = client.getInetAddress();
				System.out.println("当前客户端的IP ： " + address.getHostAddress());
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
