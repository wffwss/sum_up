package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//�ֽ���������������ȡ����
public class FileInputStreamDemo {
	//ʹ����������Ϊ�ĸ�����
	public static void main(String[] args) {
		
		//��һ����ѡ��Ŀ��Դ
		File file = new File("d:/2.txt");
		
		//�ڶ�����ѡ�������
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			
			//���������������в���������д
			
			//һ���Զ�ȡһ���ֽ�
			System.out.println((char)inputStream.read());//���������ж�ȡ���ݵ���һ���ֽ�
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
			
			//һ���Զ�ȡ����ֽ�
			byte[] b = new byte[inputStream.available()];
			//inputStream.available()��ʾ���ܵ��ֽڸ���
		
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
			//���Ĳ����ر������ͷ���Դ
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
