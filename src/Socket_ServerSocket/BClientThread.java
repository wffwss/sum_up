package Socket_ServerSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class BClientThread implements Runnable {
	private Socket client0;
	private BufferedReader reader=null;

	public BClientThread(Socket client) throws IOException {
		this.client0 = client;
		this.reader = new BufferedReader(new InputStreamReader(client0.getInputStream()));
	}

	@Override
	public void run() {
		try {
			String content = null;
			while ((content = reader.readLine()) != null) {
				System.out.println("来自服务器的数据"+content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
