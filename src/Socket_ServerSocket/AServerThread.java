package Socket_ServerSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class AServerThread implements Runnable {
	//指定要为哪个客户端服务,加0是为了与其他客户端区分
	private Socket client0;
	
	//获取客户端(client0)的输入流，以便读取数据，实现转发
	private BufferedReader reader=null;

	public AServerThread(Socket client0) throws IOException {
		this.client0 = client0;
		this.reader = new BufferedReader(new InputStreamReader(client0.getInputStream()));
	}

	@Override
	
	public void run() {
		//1.读取数据
		try {
			String content = null;
			/*//当客户端不是发送消息的客户端时，并不会执行此while，一旦有客户发送消息，则服务器会执行，那么所有的客户在此while中也都将
			//接收到消息，当然此消息是服务器转发的，并不是直接来自发送消息的客户端*/			
			while ((content = reader.readLine())!= null) {
				//为socketpool里的所有socket都传数据，且只要有socket发数据，就都会收到
				for (Socket client : AServer.socketPool) {
					//2.写数据
					//2.1获取输出流，转换成PrintWriter
					try {
						
						//clienti.getOutputStream()(字节流)-->OutputStreamWriter(字符流)-->PrintWriter处理流
						OutputStream OutputStream=client.getOutputStream();
						PrintWriter writer=new PrintWriter(new OutputStreamWriter(OutputStream));
						
						writer.println("您好，此消息来自于服务端"+Thread.currentThread().getName()
								+ "说:" + content );
						//所有写以后都不要忘了刷新
						writer.flush();
					} catch (Exception e) {
						AServer.socketPool.remove(client);
						e.printStackTrace();
					}
					
				}
				System.out.println(Thread.currentThread().getName() + "说:" + content);
				/*for(int i=0;i<AServer.socketPool.size();i++){
					System.out.println(AServer.socketPool);
				}*/

			}
		} catch (IOException e) {
			//一出现异常，立刻移出服务器的连接池
			AServer.socketPool.remove(client0);
			e.printStackTrace();
		}
	}

}
