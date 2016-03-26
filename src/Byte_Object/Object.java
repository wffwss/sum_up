package Byte_Object;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class Object{

	/**
	 * 
	 */
	//写入数据
	public void save(Student student){
		 File file=new File("d:/1.txt");
		 OutputStream out;
		 ObjectOutputStream objectOutputStream=null;
		try {
			
			out = new FileOutputStream(file);
			objectOutputStream=new ObjectOutputStream(out);
			
			objectOutputStream.writeObject(student);
			System.out.println("写入成功");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	}
	public void readerStudent(){
		File file=new File("d:/1.txt");
		 InputStream in;
		 ObjectInputStream objectinputStream=null;
		try {
			
			in = new FileInputStream(file);
			objectinputStream=new ObjectInputStream(in);
			
			Student student=(Student) objectinputStream.readObject();
			
			System.out.println(student.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student=new Student("王芳芳", 20);
		Object object=new Object();
		object.save(student);
		object.readerStudent();
	}

}
