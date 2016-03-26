package List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
	Scanner in=new Scanner(System.in);
	List<Student> ls=new ArrayList<Student>();
	
	//初始化学生信息
	public  void Init() {
		
		Student s1 = new Student("Rose", 20);
		Student s2 = new Student("张丰歌", 21);
		Student s3=new Student();
		s3.setName("柴碧云");
		s3.setAge(20);
		ls.add(s1);ls.add(s2);ls.add(s3);
		
		
	}
	
	//增加学生信息
	public  void Add(){
		Student s=new Student();
		System.out.print("请输入姓名");
		String name=in.next();
		System.out.print("请输入年龄");
		int age=in.nextInt();
	    
		s.setName(name);
		s.setAge(age);
		ls.add(s);
		System.out.println("*****已成功添加*****");
		//这样也可以
		Student ss=new Student(name,age);
		ls.add(s);
	}
	
	//删除学生信息（根据姓名）
	public void Del(String name){
		int aa=0;//标识该生是否存在
		int count=0;
		for(int i=0;i<ls.size();i++){
			if(ls.get(i).getName().equals(name)){
				count++;
				ls.remove(ls.get(i));
				aa=1;
				System.out.println("*****已成功删除*****");
				
			}
		}
		if(count>=2){
			System.out.println("*****该姓名的学生存在多个*****");
		}
		if(aa==0){
			System.out.println("*****该学生不存在*****");
		}
	}	
	
	//更新学生信息（根据姓名）
	public void update(String name){
		int aa=0;//标识该生是否存在
		int count=0;
		for(int i=0;i<ls.size();i++){
			if(ls.get(i).getName().equals(name)){
				count++;
				if(count>=2){
					System.out.println("该姓名的学生存在多个，请依次输入");
				}
				System.out.print("请输入新的姓名");
				String names=in.next();
				System.out.print("请输入新的年龄");
				int age=in.nextInt();
				ls.get(i).setName(names);
				ls.get(i).setAge(age);
				aa=1;
				System.out.println("*****已成功修改*****");
			}
		}
		if(aa==0){
			System.out.println("*****该学生不存在*****");
		}
		
	}
	
	//查询所有学生信息
    public  void selectAll(){
		for(int i=0;i<ls.size();i++){
			System.out.println("名字："+ls.get(i).getName() );
			System.out.println("年龄："+ls.get(i).getAge() );
		}
	}
    
    //根据姓名查询学生信息
    public void selectByName(String name){
		int aa=0;//标识该生是否存在
		for(int i=0;i<ls.size();i++){
			if(ls.get(i).getName().equals(name)){
				
				System.out.println("名字："+ls.get(i).getName() );
				System.out.println("年龄："+ls.get(i).getAge() );
				aa=1;
				System.out.println();
			}
		}
		if(aa==0){
			System.out.println("*****该学生不存在*****");
		}
		
	}
	
    //选择操作
	public  void Choice(){
		
		System.out.println("                         请输入您的选择1-6");
		System.out.println("           | 1 增加学生  |");
		System.out.println("           | 2 显示学生  |");
		System.out.println("           | 3 修改学生  |");
		System.out.println("           | 4 删除学生  |");
		System.out.println("           | 5 查找学生  |");
		System.out.println("           | 6 退出程序  |");
		
		int choice=in.nextInt();
		switch (choice) {
		case 1:
			Add();
			System.out.println("--------------------");
			System.out.println("继续请按1  退出请按其他");
			if(in.nextInt()==1){
				Choice();
			}
			else {
				System.out.println("已成功退出");
				System.exit(0);
			}
			break;
			
        case 2:
        	selectAll();
        	System.out.println("--------------------");
        	System.out.println("继续请按1 退出请按其他");
			if(in.nextInt()==1){
				Choice();
			}
			else {
				System.out.println("已成功退出");
				System.exit(0);
			}
			break;
	    case 3:
	    	System.out.println("请输入所要修改学生的姓名");
	    	update(in.next());
	    	System.out.println("--------------------");
	    	System.out.println("继续请按1 退出请按其他");
			if(in.nextInt()==1){
				Choice();
			}
			else {
				System.out.println("已成功退出");
				System.exit(0);
			}
			break;
        case 4:
        	System.out.println("请输入所要删除学生的姓名");
			Del(in.next());
			System.out.println("--------------------");
			System.out.println("继续请按1 退出请按其他");
			if(in.nextInt()==1){
				Choice();
			}
			else {
				System.out.println("已成功退出");
				System.exit(0);
			}
			break;

	    case 5:
	    	System.out.println("请输入所要查询学生的姓名");
        	selectByName(in.next());
        	System.out.println("--------------------");
        	System.out.println("继续请按1 退出请按其他");
			if(in.nextInt()==1){
				Choice();
			}
			else {
				System.out.println("已成功退出");
				System.exit(0);
			}
			break;
        case 6:
        	System.out.println("已成功退出");
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
