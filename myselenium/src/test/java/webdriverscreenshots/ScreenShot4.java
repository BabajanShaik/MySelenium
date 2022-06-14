package webdriverscreenshots;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot4 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		
		for(int i=0;i<links.size();i++)
		{
			if(!links.get(i).getText().isEmpty())
			{
				 String Lname = links.get(i).getText();
				 links.get(i).click();
				 
				 File scrnshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 FileHandler.copy(scrnshot, new File("C:\\Users\\user\\Desktop\\ScreenShots\\"+Lname+".png"));
				 links = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
			}
		}
		driver.close();
		System.out.println("ScreenShots Taken Successfully....");
	}

}
