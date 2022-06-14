package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestionsBox 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Hyderabad");
		Thread.sleep(3000);
		
		List<WebElement> Suggestions = driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));
	
		for (WebElement list : Suggestions) 
		{
			System.out.println(list.getText());
			if(list.getText().trim().equalsIgnoreCase("Hyderabad News"))
			{
				list.click();
				break;
			}
			
		}
	}

}
