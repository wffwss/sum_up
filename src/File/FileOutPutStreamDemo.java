package File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutPutStreamDemo {

	public static void main(String[] args) {
		File file = new File("d:/3.txt");
		OutputStream out = null;
		try {
			out = new FileOutputStream(file);
			out.write(97);// 将指定的字节写入此输出流。
			out = new FileOutputStream(file,true);//在文件末尾追加新的字节
			out.write(98);//一次写一个字节
			//使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
			out.write("苏州".getBytes());//将 b.length 个字节从指定的 byte 数组写入此输出流。
			System.out.println("写入数据成功");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
