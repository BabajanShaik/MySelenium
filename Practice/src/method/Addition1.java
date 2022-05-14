package method;

//Method without return type and without parameters

public class Addition1 
{

	void add()
	{
		int x = 10;
		int y = 20;
		int z = x+y;
		System.out.println(z);
	}
	public static void main(String[] args) 
	{
		Addition1 ad = new Addition1();
		ad.add();
	}

}
