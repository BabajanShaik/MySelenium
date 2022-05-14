package method;

	//Method returning an Array.

public class ArrayDemo4 
{
	int[] getArray()
	{
		int[] name = {10,20,30,40,50};
		return name;
	}
	public static void main(String[] args) 
	{
		ArrayDemo4 ad = new ArrayDemo4();
		int[] abc = ad.getArray();
		for(int x:abc)
		{
			System.out.println(x);
		}
	}

}
