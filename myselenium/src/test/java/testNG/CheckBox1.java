package testNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import launch.RootTest;

public class CheckBox1  extends RootTest
{
  
	@BeforeMethod(groups = {"regression","smoke"})
	@Parameters("browser")
	public void beforeMethod(String bType) throws Exception 
	{
		System.out.println("startProcess");
	    initiate();
		test = rep.createTest("CheckBox1");
		test.log(Status.PASS, "Initiating the Property Files...");
				
		launch(bType);
		test.log(Status.INFO, "Opened the Browser :- " + d.getProperty("chromebrowser"));
						
		naviagteUrl("chekboxurl");
		test.log(Status.PASS, "Navigated to app :-" + childprop.getProperty("chekboxurl"));
	}
	  
	  
	@Test(groups = {"regression","smoke"})
	public void checkboxTest()
	{
		List<WebElement> check=driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		for(int i=0;i<check.size();i++)
		{
			System.out.println(check.get(i).getAttribute("value")+"--"+check.get(i).getAttribute("checked"));
			//System.out.println(check.get(i).isSelected());
		}
	}
 

  @AfterMethod(groups = {"regression","smoke"})
  public void afterMethod() 
  {
	  System.out.println("endProcess");
	  	rep.flush();
		driver.quit();
  }

}
