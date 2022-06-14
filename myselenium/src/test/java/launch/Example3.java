package launch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example3 {

	public static void main(String[] args) throws Exception 
	{
		//Pagination
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://datatables.net/examples/advanced_init/events_live.html");
		int pageMaxSize = driver.findElements(By.cssSelector("div#example_paginate>span>a")).size();
		System.out.println("Total Number Of Pages: "+pageMaxSize);
		
		for(int i=1;i<=pageMaxSize;i++)
		{
			String pageselector = "div#example_paginate>span>a:nth-child("+i+")";
			driver.findElement(By.cssSelector(pageselector)).click();
			
			List<WebElement> elementNames = driver.findElements(By.cssSelector("table#example>tbody>tr>td:nth-child(1)"));
			for (WebElement elementName : elementNames) 
			{
				System.out.println(elementName.getText());
			}
			Thread.sleep(3000);
		}

	}

}
