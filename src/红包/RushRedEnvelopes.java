package 红包;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class RushRedEnvelopes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket client=new Socket("127.0.0.1",12241);
			//启动一条线程获取服务器数据
			new Thread(new RushThread(client)).start();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			OutputStream  outputStream=client.getOutputStream();
			PrintWriter writer=new PrintWriter(new OutputStreamWriter(outputStream));
			String content=null;
			//发送给服务器的消息
			while((content=reader.readLine())!=null){
				writer.println(content);
				writer.flush();
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
