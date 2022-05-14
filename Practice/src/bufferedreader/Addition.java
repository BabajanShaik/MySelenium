package bufferedreader;

import java.io.*;

public class Addition {

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter first number:");
		String s1 =	br.readLine();
		int fno = Integer.parseInt(s1);
		
		System.out.println("enter second number:");
		String s2 =	br.readLine();
		int sno = Integer.parseInt(s2);
		
		System.out.println("Result:"+(fno+sno));

	}

}
