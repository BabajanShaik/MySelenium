package launch;

public class TC001 extends RootTest
{

	public static void main(String[] args) throws Exception 
	{
		launch("chrome");
		
		naviagteUrl("https://amazon.in");
		
		driver.manage().window().maximize();
				
		String title = driver.getTitle();
		System.out.println(title);
		
		String ur = driver.getCurrentUrl();
		System.out.println(ur);
		
		String ps = driver.getPageSource();
		System.out.println(ps);
				
		String wh = driver.getWindowHandle();
		System.out.println(wh);
		
		driver.manage().deleteAllCookies();
				
		driver.navigate().back();
		
		Thread.sleep(4000);
		
		driver.navigate().forward();
		driver.navigate().refresh();
		
		//driver.quit();
		driver.close();
	}

}
