package launch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC006 extends RootTest
{

	public static void main(String[] args) throws Exception 
	{
		initiate();
		
		launch("chromebrowser");
		
		naviagteUrl("amazonurl");
		
		/*driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Tv's");
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("field-keywords")).clear();
		
		Thread.sleep(3000);
		
		driver.findElement(By.className("nav-input")).sendKeys("shirts for men");
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText(" Electronics "));
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("mens track pants");*/
		
		//driver.findElement(By.linkText(" Electronics ")).click();
		
		//driver.findElement(By.partialLinkText("Home")).click();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(int i=0;i<links.size();i++)
		{
			if(!links.get(i).getText().isEmpty())
			System.out.println(links.get(i).getText());
		}
		
	}

}
