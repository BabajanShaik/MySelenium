package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action3 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/slider/");
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement slide = driver.findElement(By.id("slider"));
		Actions actions = new Actions(driver);
		//actions.dragAndDropBy(slide, 100, 0).perform();
		actions.clickAndHold(slide).moveByOffset(100, 0).release(slide).build().perform();
		
		//Right Click On Element
		driver.switchTo().defaultContent();
		WebElement link = driver.findElement(By.linkText("Selectable"));
		actions.contextClick(link).perform();
	}

}
