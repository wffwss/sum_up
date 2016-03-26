package File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;

public class FileCopyDemo {
	
	public static void copyFile(File file, File file2){
		//字节输入流没有使用到缓存区,即使不关闭流也可以输出数据，而字符输入流使用到了缓冲区，必须显示调用flush方法，要么调用close
		//文件类应该选择字节还是字符流呢？若文件是多媒体类型的文件（图片、音乐、视频），则只能使用字节流
		//若文件类型为文档文件(txt,doc等)，则优先选择字符流
		//取出原来文件的所有内容
		Reader reader = null;
		Writer writer = null;
		try {
			reader = new FileReader(file);
			writer = new FileWriter(file2);
			//若不清楚文档字符总数，定义缓存数组大小最好设置为1024的倍数
			char[] cbuf = new char[1024];
			int len;//每次读取的字符数量
			/*//存储读取出来的所有内容
			StringBuilder builder = new StringBuilder();
			while ((len = reader.read(cbuf)) != -1) {
				if (len < cbuf.length) {
					//最后一次读取的数据不能填满缓冲数组
					builder.append(Arrays.copyOf(cbuf, len));
				} else {
					builder.append(cbuf);
				}
			}
			//把旧文件中的内容写入到新文件中
			writer.write(builder.toString());*/
			//边读边写
			while ((len = reader.read(cbuf)) != -1) {
				//当前次读取的数据都已经保存到cbuf字符数组中
				writer.write(cbuf, 0, len);
			}
			System.out.println("复制文件结束");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		File file = new File("d:/1.txt");
		File file2 = new File("e:/1.txt");
		copyFile(file, file2);
	}

}

