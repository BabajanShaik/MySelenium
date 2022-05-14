package method;

//Method with return type and with parameters

public class Addition4 
{
	double add(double a,double b)
	{
		double c = a+b;
		return c;
	}
	public static void main(String[] args) 
	{
		Addition4 ad = new Addition4();
		double result = ad.add(12.5, 37.5);
		System.out.println(result);
	}

}
