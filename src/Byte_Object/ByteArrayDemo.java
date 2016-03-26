package Byte_Object;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayDemo {

	public static void main(String[] args) {
		// 对内存流先写再读
		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		//写
		try {
			bOut.write("abced".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bOut != null) {
				try {
					bOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//读,buf是读取内容的缓存区
		byte[] buf = bOut.toByteArray();//把内存输出流在缓存区的数据取出来
		ByteArrayInputStream bIn = new ByteArrayInputStream(buf);
		try {
			byte[] buf2 = new byte[buf.length];//把读取出来的内容暂时缓存到buf2中
			bIn.read(buf2);
			System.out.println(new String(buf2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bIn.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
