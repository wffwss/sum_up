package Socket_ServerSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * BufferedReader reader = new BufferedReader(new InputStreamReader(target1));
 * 你想接收哪个输入流接收到的消息，target1就写谁
 * 
 * PrintWriter writer=new PrintWriter(new OutputStreamWriter(target2));
 * 你想向哪个输出流传数据，target2就写谁
 *
 */

//服务器就是接收client0发送来的消息并写入输出流，而reader是接收client发送来的消息并通过reader（输入流）输出
public class AServer {
	//客户端socket池
	public static List<Socket> socketPool = new ArrayList<>();

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(3333);
			while (true) {
				Socket client = server.accept();//侦听并接受到此套接字的连接。
				//每接收到一个连接，就将请求连接的客户端socket加入socket池
				socketPool.add(client);
				new Thread(new AServerThread(client)).start();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
