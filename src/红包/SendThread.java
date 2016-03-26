package 红包;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class SendThread implements Runnable {

	boolean flag = true;//用来标识客户是否是第一次抢红包
	//切记，此client0不能用静态的，因为用了ststic表明线程共用。当开了线程1，再开线程2，当你返到线程1去操作时，client0
	//并不是指线程1的，而是最新开的线程。因为client0是由所有线程共同操作的，但是Thread.currentThread().getName()
	//并不会出错，是指线程1的
	private  Socket client0;
	private BufferedReader reader = null;
	//用list来存放客户 
	private static List<Socket> list = SendRedEnvelopes.socketPool;
	private static Map<String, Double> map=new TreeMap<>();//存放抢到红包的客户以及抢到的红包钱数

	public SendThread(Socket client0) throws IOException {

		this.client0 = client0;
		this.reader = new BufferedReader(new InputStreamReader(
				client0.getInputStream()));
	}
	//当钱包还有的时候，通知客户抢到的钱包情况
	public  void Notify(){
		
			try {
				OutputStream OutputStream =client0.getOutputStream();
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(OutputStream));
				writer.println("恭喜您抢到"+ SendRedEnvelopes.gMoney[SendRedEnvelopes.persion] + "元");
				// 所有写以后都不要忘了刷新
				writer.flush();
				map.put(Thread.currentThread().getName(),SendRedEnvelopes.gMoney[SendRedEnvelopes.persion]);
				System.out.println(client0);
			} catch (Exception e) {
				SendRedEnvelopes.socketPool.remove(client0);
				e.printStackTrace();
			}
		
		    System.out.println(Thread.currentThread().getName()+ "抢到"+SendRedEnvelopes.gMoney[SendRedEnvelopes.persion]+"元");
	}
	
	//当钱包已被抢完时，通知客户钱包已被抢完
	public  void Notify2(){
		
			try {
				OutputStream OutputStream = client0.getOutputStream();
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(OutputStream));
				writer.println("手慢了，红包已被抢完");
				// 所有写以后都不要忘了刷新
				writer.flush();
			} catch (Exception e) {
                SendRedEnvelopes.socketPool.remove(client0);
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName()+"进来，但红包已被抢完");
	}
	
	//当客户重复领取时
	public  void Notify3(){
			try {
				OutputStream OutputStream = client0.getOutputStream();
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(OutputStream));
				writer.println("您已领取，不可重复领取");
				// 所有写以后都不要忘了刷新
				writer.flush();
			} catch (Exception e) {
				SendRedEnvelopes.socketPool.remove(client0);
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "重复领取");
	}
	
	//口令错误时
	public  void Notify4(){
			try {
				OutputStream OutputStream = client0.getOutputStream();
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(OutputStream));
				writer.println("口令错误");
				// 所有写以后都不要忘了刷新
				writer.flush();
			} catch (Exception e) {
				SendRedEnvelopes.socketPool.remove(client0);
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "口令错误");
	}
	
	//当红包被抢完时，通知谁是运气王
	public  void Notify5(){
		Set<Entry<String,Double>> entrys = map.entrySet();//返回此映射中包含的映射关系的 Set 视图。
		double max=0;String con="";
		for (Entry<String,Double> entry : entrys) {
			if(entry.getValue()>max){
				max=entry.getValue();
				con=entry.getKey();
			}	
		}
		for(Socket socket:SendRedEnvelopes.socketPool){
			try {
				OutputStream OutputStream = socket.getOutputStream();
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(OutputStream));
				writer.println(con+ "【是运气王】，领取了" +max+"元钱");
				// 所有写以后都不要忘了刷新
				writer.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(con+ "【是运气王】，领取了" +max+"元钱");
	}
	@Override
	public void run() {
		
		try {
			
			String content = null;
			while ((content = reader.readLine())!=null) {
				
				//当用户正确输入口令
				if (content.equals("y")) {
					//当红包还有剩余
					if(SendRedEnvelopes.remainder > 0 ){
						//当此客户是第一次抢红包
						if((flag == true)){
							SendRedEnvelopes.persion++;//第几个客户抢红包
							SendRedEnvelopes.remainder = SendRedEnvelopes.remainder - 1;
							Notify();//当钱包还有的时候，通知客户钱包发放情况
							flag = false;//一旦客户抢过红包，则不允许再次抢红包
						}
						else{
							Notify3();//当客户重复领取时，通知客户不可重复领取
						}
					}
					//当红包已被抢完时
					else {
						Notify2();//通知所有客户钱包已被抢完
						Notify5();//服务器得知谁是运气王
					}	
				}
				else{
					Notify4();//当口令错误时
				}
				
			}
			

		} catch (IOException e1) {
		    
			e1.printStackTrace();
		}

	}

}
