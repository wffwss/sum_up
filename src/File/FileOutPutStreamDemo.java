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
			out.write(97);// ��ָ�����ֽ�д����������
			out = new FileOutputStream(file,true);//���ļ�ĩβ׷���µ��ֽ�
			out.write(98);//һ��дһ���ֽ�
			//ʹ��ƽ̨��Ĭ���ַ������� String ����Ϊ byte ���У���������洢��һ���µ� byte �����С�
			out.write("����".getBytes());//�� b.length ���ֽڴ�ָ���� byte ����д����������
			System.out.println("д�����ݳɹ�");
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
