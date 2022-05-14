package method;

//Method without return type and with parameters

public class Addition2 
{
	void add(double x, double y)
	{
		double z = x+y;
		System.out.println(z);
	}
	public static void main(String[] args) 
	{
		Addition2 ad = new Addition2();
		double x = 12.5;
		double y = 12.5;
		ad.add(x,y);
	}

}
