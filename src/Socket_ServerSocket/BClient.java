package Socket_ServerSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
//客户端就是主线程向服务器发送消息（即将信息写入输出流），并启动一条子线程来获取服务器转发来的消息
public class BClient {
   //一旦创建好socket对象，且和服务器的端口一致，那么将会执行Aserver的socketPool.add(client)并为之创建进程
	public static void main(String[] args) {
		try {
			//创建客户端Socket
			Socket client=new Socket("127.0.0.1",3333);
			//启动一条线程获取服务器数据,因为只要是socke，就会进入sockettpool，而socketpool里的socket都有数据
			new Thread(new BClientThread(client)).start();
			//不断读取键盘输入，并写入输出流。即主线程向服务器发送消息
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			OutputStream  outputStream=client.getOutputStream();
			PrintWriter writer=new PrintWriter(new OutputStreamWriter(outputStream));
			String content=null;
			//客户端将消息发送给服务器。原理：对于OutputStream out=new OutputStream（target）；
			//                   是指接下来你写入的数据content{out.write/println(content)}
			//                   都将保存在target中，也就是说，客户端向服务器传输需要输出流，而输出流的目标源就是client
			//过程：客户端发送的消息首先会写入client,此时是字节，然后又变成字符，又被包装，最后的输出流就为writer
			//前面说过只要是新建一个socket且ip与端口号都符合，那么就会进入socketPool，并为之创建进程，因为不为空，则会执行
			//AServerThread里的for循环，这样服务器会将client传过来的数据存到clienti中（即每一个client）
			//然后再执行18行时的client就会是已经有数据的
			while((content=reader.readLine())!=null){
				writer.println(content);
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
