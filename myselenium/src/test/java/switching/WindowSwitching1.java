package switching;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowSwitching1 
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.icicibank.com/");
		
		/*String parentHandle = driver.getWindowHandle();
		System.out.println(parentHandle);
		
		String ParentTitle = driver.getTitle();
		System.out.println("ParentTitle:"+ParentTitle);*/
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		while(!wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//img[@alt='Generic HL'])[1]"))).isDisplayed());
		{
			driver.findElement(By.xpath("//div[@class='banner-slider i-home-banner desktop slick-initialized slick-slider slick-dotted']//button[contains(text(),'Next')]")).click();
			
		}
		driver.findElement(By.xpath("(//img[@alt='Generic HL'])[1]")).click();
		
		Set<String> windowhandleIds = driver.getWindowHandles();
		ArrayList<String> winhandles = new ArrayList<String>(windowhandleIds);
		
		for (String i : winhandles) 
		{
			System.out.println(i);
		}
		
		driver.switchTo().window(winhandles.get(1));
		String ChildTitle = driver.getTitle();
		System.out.println("ChildTitle:"+ChildTitle);
		driver.close();
		
		driver.switchTo().window(winhandles.get(0));
		String ParentTitle = driver.getTitle();
		System.out.println("ParentTitle:"+ParentTitle);
		driver.close();
	}

}
