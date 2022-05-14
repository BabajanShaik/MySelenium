package method;

	//Method taking object as parameter

public class Student 
	{
	int rollno = 217;
	double marks = 96.1;
	String name = "babajan";
	}
	
	class ObjectDemo
	{
		void display(Student stu)
		{
			System.out.println(stu.rollno);
			System.out.println(stu.marks);
			System.out.println(stu.name);
		}
	
	public static void main(String[] args)
		{
			Student st = new Student();
			ObjectDemo od = new ObjectDemo();
			od.display(st);
		}
	}
