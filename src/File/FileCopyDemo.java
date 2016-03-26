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
		//�ֽ�������û��ʹ�õ�������,��ʹ���ر���Ҳ����������ݣ����ַ�������ʹ�õ��˻�������������ʾ����flush������Ҫô����close
		//�ļ���Ӧ��ѡ���ֽڻ����ַ����أ����ļ��Ƕ�ý�����͵��ļ���ͼƬ�����֡���Ƶ������ֻ��ʹ���ֽ���
		//���ļ�����Ϊ�ĵ��ļ�(txt,doc��)��������ѡ���ַ���
		//ȡ��ԭ���ļ�����������
		Reader reader = null;
		Writer writer = null;
		try {
			reader = new FileReader(file);
			writer = new FileWriter(file2);
			//��������ĵ��ַ����������建�������С�������Ϊ1024�ı���
			char[] cbuf = new char[1024];
			int len;//ÿ�ζ�ȡ���ַ�����
			/*//�洢��ȡ��������������
			StringBuilder builder = new StringBuilder();
			while ((len = reader.read(cbuf)) != -1) {
				if (len < cbuf.length) {
					//���һ�ζ�ȡ�����ݲ���������������
					builder.append(Arrays.copyOf(cbuf, len));
				} else {
					builder.append(cbuf);
				}
			}
			//�Ѿ��ļ��е�����д�뵽���ļ���
			writer.write(builder.toString());*/
			//�߶���д
			while ((len = reader.read(cbuf)) != -1) {
				//��ǰ�ζ�ȡ�����ݶ��Ѿ����浽cbuf�ַ�������
				writer.write(cbuf, 0, len);
			}
			System.out.println("�����ļ�����");
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

