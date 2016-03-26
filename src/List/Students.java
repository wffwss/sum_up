package List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
	Scanner in=new Scanner(System.in);
	List<Student> ls=new ArrayList<Student>();
	
	//��ʼ��ѧ����Ϣ
	public  void Init() {
		
		Student s1 = new Student("Rose", 20);
		Student s2 = new Student("�ŷ��", 21);
		Student s3=new Student();
		s3.setName("�����");
		s3.setAge(20);
		ls.add(s1);ls.add(s2);ls.add(s3);
		
		
	}
	
	//����ѧ����Ϣ
	public  void Add(){
		Student s=new Student();
		System.out.print("����������");
		String name=in.next();
		System.out.print("����������");
		int age=in.nextInt();
	    
		s.setName(name);
		s.setAge(age);
		ls.add(s);
		System.out.println("*****�ѳɹ����*****");
		//����Ҳ����
		Student ss=new Student(name,age);
		ls.add(s);
	}
	
	//ɾ��ѧ����Ϣ������������
	public void Del(String name){
		int aa=0;//��ʶ�����Ƿ����
		int count=0;
		for(int i=0;i<ls.size();i++){
			if(ls.get(i).getName().equals(name)){
				count++;
				ls.remove(ls.get(i));
				aa=1;
				System.out.println("*****�ѳɹ�ɾ��*****");
				
			}
		}
		if(count>=2){
			System.out.println("*****��������ѧ�����ڶ��*****");
		}
		if(aa==0){
			System.out.println("*****��ѧ��������*****");
		}
	}	
	
	//����ѧ����Ϣ������������
	public void update(String name){
		int aa=0;//��ʶ�����Ƿ����
		int count=0;
		for(int i=0;i<ls.size();i++){
			if(ls.get(i).getName().equals(name)){
				count++;
				if(count>=2){
					System.out.println("��������ѧ�����ڶ��������������");
				}
				System.out.print("�������µ�����");
				String names=in.next();
				System.out.print("�������µ�����");
				int age=in.nextInt();
				ls.get(i).setName(names);
				ls.get(i).setAge(age);
				aa=1;
				System.out.println("*****�ѳɹ��޸�*****");
			}
		}
		if(aa==0){
			System.out.println("*****��ѧ��������*****");
		}
		
	}
	
	//��ѯ����ѧ����Ϣ
    public  void selectAll(){
		for(int i=0;i<ls.size();i++){
			System.out.println("���֣�"+ls.get(i).getName() );
			System.out.println("���䣺"+ls.get(i).getAge() );
		}
	}
    
    //����������ѯѧ����Ϣ
    public void selectByName(String name){
		int aa=0;//��ʶ�����Ƿ����
		for(int i=0;i<ls.size();i++){
			if(ls.get(i).getName().equals(name)){
				
				System.out.println("���֣�"+ls.get(i).getName() );
				System.out.println("���䣺"+ls.get(i).getAge() );
				aa=1;
				System.out.println();
			}
		}
		if(aa==0){
			System.out.println("*****��ѧ��������*****");
		}
		
	}
	
    //ѡ�����
	public  void Choice(){
		
		System.out.println("                         ����������ѡ��1-6");
		System.out.println("           | 1 ����ѧ��  |");
		System.out.println("           | 2 ��ʾѧ��  |");
		System.out.println("           | 3 �޸�ѧ��  |");
		System.out.println("           | 4 ɾ��ѧ��  |");
		System.out.println("           | 5 ����ѧ��  |");
		System.out.println("           | 6 �˳�����  |");
		
		int choice=in.nextInt();
		switch (choice) {
		case 1:
			Add();
			System.out.println("--------------------");
			System.out.println("�����밴1  �˳��밴����");
			if(in.nextInt()==1){
				Choice();
			}
			else {
				System.out.println("�ѳɹ��˳�");
				System.exit(0);
			}
			break;
			
        case 2:
        	selectAll();
        	System.out.println("--------------------");
        	System.out.println("�����밴1 �˳��밴����");
			if(in.nextInt()==1){
				Choice();
			}
			else {
				System.out.println("�ѳɹ��˳�");
				System.exit(0);
			}
			break;
	    case 3:
	    	System.out.println("��������Ҫ�޸�ѧ��������");
	    	update(in.next());
	    	System.out.println("--------------------");
	    	System.out.println("�����밴1 �˳��밴����");
			if(in.nextInt()==1){
				Choice();
			}
			else {
				System.out.println("�ѳɹ��˳�");
				System.exit(0);
			}
			break;
        case 4:
        	System.out.println("��������Ҫɾ��ѧ��������");
			Del(in.next());
			System.out.println("--------------------");
			System.out.println("�����밴1 �˳��밴����");
			if(in.nextInt()==1){
				Choice();
			}
			else {
				System.out.println("�ѳɹ��˳�");
				System.exit(0);
			}
			break;

	    case 5:
	    	System.out.println("��������Ҫ��ѯѧ��������");
        	selectByName(in.next());
        	System.out.println("--------------------");
        	System.out.println("�����밴1 �˳��밴����");
			if(in.nextInt()==1){
				Choice();
			}
			else {
				System.out.println("�ѳɹ��˳�");
				System.exit(0);
			}
			break;
        case 6:
        	System.out.println("�ѳɹ��˳�");
        	System.exit(0);
			break;


		default:
			break;
		}
	}
	
	
	public static void main(String[] args) {
		Students students=new Students();
		students.Init();
		students.Choice();
		
	}

}
