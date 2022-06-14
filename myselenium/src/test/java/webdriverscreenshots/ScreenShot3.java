package webdriverscreenshots;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot3 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		
		String text1 = driver.findElement(By.linkText("Images")).getText();
		System.out.println(text1);
		
		System.out.println("*************************************");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++)
		{
			if(!links.get(i).getText().isEmpty())
			{
				System.out.println(links.get(i).getText());
			}
		}
		
		System.out.println("**************************************");
		
		List<WebElement> texts = driver.findElements(By.xpath("//div[@class='gb_6d gb_f gb_kg gb_bg']/div/a"));
		for(int j=0;j<texts.size();j++)
		{
			System.out.println(links.get(j).getText());
		}
	}

}
