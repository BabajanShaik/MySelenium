package commandlinearguments.parsing;

public class Addition {

	public static void main(String[] args) 
	{
		String abc[] = new String[2];
		abc[0]="10";
		abc[1]="20";
		int x = Integer.parseInt(abc[0]);
		int y = Integer.parseInt(abc[1]);
		int z = x+y;
		System.out.println(z);

	}

}
