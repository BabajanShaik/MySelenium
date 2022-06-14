package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action1 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com");
		
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Sign In')]"));
		actions.moveToElement(element).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Your Account')]")).click();
	}

}
