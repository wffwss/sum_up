package Byte_Object;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class RandomFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file=new File("D:/1.txt");
		
		RandomAccessFile randomAccessFile=null;
		try {
			
            randomAccessFile = new RandomAccessFile(file, "rw");
            //д����
			randomAccessFile.writeByte(97);
			randomAccessFile.writeChars("hello������");
			randomAccessFile.writeByte(33);
			
			
			//������
			//����Ҫ��ָ��λ�øĹ���������ᱨָ��Խ�����
			/*randomAccessFile.seek(0);
			
			
			System.out.println(randomAccessFile.readByte());
			System.out.println(randomAccessFile.getFilePointer());
			
			
			System.out.println(randomAccessFile.readChar());
			System.out.println(randomAccessFile.getFilePointer());*/
			randomAccessFile.seek(17);
		//	System.out.println(randomAccessFile.readChar());
		//	System.out.println(randomAccessFile.getFilePointer());
			
			//randomAccessFile.seek(17);
			System.out.println(randomAccessFile.readByte());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
