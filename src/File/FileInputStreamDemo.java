package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//字节输入流，用来读取内容
public class FileInputStreamDemo {
	//使用流基本分为四个步骤
	public static void main(String[] args) {
		
		//第一步：选择目标源
		File file = new File("d:/2.txt");
		
		//第二步：选择操作流
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			
			//第三步：对流进行操作：读或写
			
			//一次性读取一个字节
			System.out.println((char)inputStream.read());//从输入流中读取数据的下一个字节
			System.out.println((char)inputStream.read());
			System.out.println((char)inputStream.read());
			System.out.println((char)inputStream.read());
			System.out.println((char)inputStream.read());
			System.out.println((char)inputStream.read());
			System.out.println((char)inputStream.read());
			System.out.println((char)inputStream.read());
			System.out.println((char)inputStream.read());
			System.out.println((char)inputStream.read());
			System.out.println((char)inputStream.read());
			System.out.println((char)inputStream.read());
			System.out.println((char)inputStream.read());
			System.out.println((char)inputStream.read());
			System.out.println((char)inputStream.read());
			System.out.println((char)inputStream.read());
			/*
			int len;
			while ((len = inputStream.read()) != -1) {
				System.out.println((char)len);
			}
			
			//一次性读取多个字节
			byte[] b = new byte[inputStream.available()];
			//inputStream.available()表示可能的字节个数
		
			while ((len = inputStream.read(b)) != -1) {
				System.out.println(len);
				System.out.println(new String(b));
			}
			*/
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//第四步：关闭流、释放资源
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
