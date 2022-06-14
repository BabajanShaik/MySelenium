package launch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example2 {

	public static void main(String[] args) 
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[contains(text(),'Departure')]")).click();
		
		List<WebElement> month = driver.findElements(By.xpath("(//div[@class='DayPicker-Caption']/div)"));
		
		int i=1;	
		System.out.println(month.get(i).getText());
		
		while(!month.get(i).getText().contains("August 2022"))
		{
			if(i<3)
				i++;
			else
				driver.findElement(By.className("DayPicker-NavButton DayPicker-NavButton--next")).click();
				i=1;
		}
		
	}

}
