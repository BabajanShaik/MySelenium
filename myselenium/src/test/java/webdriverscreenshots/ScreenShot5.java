package webdriverscreenshots;

import java.util.Date;

public class ScreenShot5 
{

	public static void main(String[] args) 
	{
		Date d = new Date();
		System.out.println(d);
		
		String dt = d.toString().replace(':', '_').replace(' ', '_');
		System.out.println(dt);
	}

}
