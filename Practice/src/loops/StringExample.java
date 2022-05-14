package loops;

public class StringExample 
{
	public static void main(String[] args) 
	{

		  String str1 = "Demo";
		  String[] str2 = str1.split("");

		   for (String ch : str2) 
		  {

		   int index = str1.indexOf(ch) + 1;

		   System.out.print(ch.repeat(index));
		  }
	}
}
