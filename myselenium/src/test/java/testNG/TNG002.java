package testNG;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import launch.RootTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TNG002 extends RootTest
{
  
	@BeforeMethod(groups = {"regression","sanity"})
	@Parameters("browser")
  public void startProcess(String bType) throws Exception 
	{
		initiate();
		test = rep.createTest("TNG002");
		test.log(Status.INFO,"Initiate the Properties Files....");
		
		launch(bType);
		test.log(Status.PASS,"Opening the Browser :-"+d.getProperty("chromebrowser"));
				
		naviagteUrl("amazonurl");
		test.log(Status.INFO, "Navigating to Application :"+childprop.getProperty("amazonurl"));	
	}
	
	@Test(groups = {"regression","sanity"})
  public void amazon() 
	{
		selectOption("amazondropbox_id","Books");
		test.log(Status.FAIL, "Selecting Option By Using Locator :"+orProp.getProperty("amazondropbox_id"));
				
		typeText("amazonsearchtextbox_id","Harry Potter");
		test.log(Status.INFO, "Typing Text Harry Potter By Using Locator : "+orProp.getProperty("amazonsearchtextbox_id"));
				
		clickElement("amazonsearchbutton_xpath");
		test.log(Status.INFO, "Clicked on Element By Using Locator :"+orProp.getProperty("amazonsearchbutton_xpath"));
	}
 
	@AfterMethod(groups = {"regression","sanity"})
  public void endProcess() 
	{
		rep.flush();
		driver.close();
	}

}
