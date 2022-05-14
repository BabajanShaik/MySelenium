package method;

//Method taking Array as parameter

public class ArrayDemo1 
{
	void display(double[] temp)
	{
		for(double x:temp)
		{
			System.out.println(x);
		}
	}

	public static void main(String[] args) 
	{
		ArrayDemo1 ad = new ArrayDemo1();
		double arr[] = {1.2,3.4,5.6,7.8};
		ad.display(arr);
		double nos[] = {1.1,2.2,3.3,4.4,5.5};
		ad.display(nos);
}
}
