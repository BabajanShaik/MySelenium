package webdriverscreenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import launch.RootTest;

public class HighlightingWebElement extends RootTest
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		
		WebElement element = driver.findElement(By.xpath("//div[@id='nav-xshop']/a[text()='Customer Service']"));
		highlightElement(driver, element);
		
		
		/*JavascriptExecutor jsExecuter = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath("//div[@id='nav-xshop']/a[text()='Customer Service']"));
		jsExecuter.executeScript("arguments[0].setAttribute('style','border:2px solid red; background:black');",element);*/
		
	}

}
