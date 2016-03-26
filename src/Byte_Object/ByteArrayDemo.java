package Byte_Object;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayDemo {

	public static void main(String[] args) {
		// ���ڴ�����д�ٶ�
		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		//д
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
		//��,buf�Ƕ�ȡ���ݵĻ�����
		byte[] buf = bOut.toByteArray();//���ڴ�������ڻ�����������ȡ����
		ByteArrayInputStream bIn = new ByteArrayInputStream(buf);
		try {
			byte[] buf2 = new byte[buf.length];//�Ѷ�ȡ������������ʱ���浽buf2��
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
