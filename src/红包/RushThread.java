package 红包;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class RushThread implements Runnable {
	private Socket client0;
	private BufferedReader reader=null;
	public RushThread(Socket client0) throws IOException {
		super();
		this.client0 = client0;
		this.reader = new BufferedReader(new InputStreamReader(client0.getInputStream()));
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String content = null;
			while ((content = reader.readLine())!= null) {
				System.out.println(content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
