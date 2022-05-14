package method;

	//Method taking Array as parameter

public class ArrayDemo2 
{
	void display(char[] temp)
	{
		for(char x:temp)
		{
			System.out.println(x);
		}
	}
	public static void main(String[] args) 
	{
		ArrayDemo2 ad = new ArrayDemo2();
		char arr[]= {'a','b','c','d','e'};
		ad.display(arr);

	}
}
