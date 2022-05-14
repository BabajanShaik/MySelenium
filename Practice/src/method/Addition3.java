package method;

//Method with return type and without parameters

public class Addition3 
{
	double add()
	{
		double a = 12.5;
		double b = 37.5;
		double c = a+b;
		return c;
	}
	public static void main(String[] args) 
	{
		Addition3 ad = new Addition3();
		ad.add();
		double result = ad.add();
		System.out.println(result);
	}

}
