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

public class RadioButton1 extends RootTest
{

	@BeforeMethod(groups = {"regression","smoke"})
	@Parameters("browser")
	public void beforeMethod(String bType) throws Exception 
	{
		System.out.println("startProcess");
	    initiate();
		test = rep.createTest("RadioButton1");
		test.log(Status.PASS, "Initiating the Property Files...");
				
		launch(bType);
		test.log(Status.INFO, "Opened the Browser :- " + d.getProperty("chromebrowser"));
						
		naviagteUrl("radiourl");
		test.log(Status.PASS, "Navigated to app :-" + childprop.getProperty("radiourl"));
	 }
	
	
	@Test(groups = {"regression","smoke"})
	public void radioButtonTest()
	{
		WebElement radio=driver.findElement(By.xpath("(//td[@class='table5'])[2]"));
		List<WebElement> rbutton=radio.findElements(By.name("group1"));
		for(int i=0;i<rbutton.size();i++)
		{
			System.out.println(rbutton.get(i).getAttribute("value")+ "----" + rbutton.get(i).getAttribute("checked"));
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
