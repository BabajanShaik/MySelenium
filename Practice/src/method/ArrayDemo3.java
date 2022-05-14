package method;

	//Method returning an Array.

public class ArrayDemo3 
{
	String[] getArray()
	{
		String[] name= {"aaa","bbb","ccc"};
		return name;
	}
	public static void main(String[] args) 
	{
		ArrayDemo3 ad = new ArrayDemo3();
		String[] abc = ad.getArray();
		for(String x:abc)
		{
			System.out.println(x);
		}
	}

}
