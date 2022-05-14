package method;

	//Method returning an Array.

public class ArrayDemo5 
{
	double add(double[] temp)
	{
		double sum = 0.0;
		for(double x:temp)
		{
			sum = sum+x;
		}
		return sum;
	}
	public static void main(String[] args) 
	{
		ArrayDemo5 ad = new ArrayDemo5();
		double arr[] = {1.1,2.2,3.3,4.4,5.5};
		double result = ad.add(arr);
		System.out.println(result);
	}
}
