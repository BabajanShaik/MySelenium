package encapsulation;

public class Student {

	int rollno;
	double marks;
	String name;
	
	void display()

	{
		System.out.println("RollNo:"+rollno);
		System.out.println("Marks:"+marks);
		System.out.println("Name:"+name);
	}
		
	public static void main(String[] args) 
	{
		System.out.println("Student Information");
		Student st = new Student();
		st.display();
	}
}
