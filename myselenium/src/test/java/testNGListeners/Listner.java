package testNGListeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import launch.RootTest;

public class Listner extends RootTest implements ITestListener 
{

	public void onTestStart(ITestResult result) 
	{
		Reporter.log("Test Started Running :" + result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) 
	{
		if(result.isSuccess())
		{
			try 
			{
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File(projectpath+"//success//"+filePath+".png"));
			
				Reporter.log("<a href='" + projectpath+"//success//"+filePath+".png" + "'> <img src='" + projectpath+"//success//"+filePath+".png" + "' height='100' width='100'/> </a>");
				Reporter.log("Test has Success:" + result.getMethod().getMethodName());
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
			
	}

	public void onTestFailure(ITestResult result) 
	{
		if(!result.isSuccess())
		{
			try 
			{
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File(projectpath+"//failure//"+filePath+".png"));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			Reporter.log("<a href='" + projectpath+"//failure//"+filePath+".png" + "'> <img src='" + projectpath+"//failure//"+filePath+".png" + "' height='100' width='100'/> </a>");
			Reporter.log("Test has Failed:" + result.getMethod().getMethodName());
			
			//For Unexpected Failures
			Reporter.log(result.getThrowable().getMessage());
		}
	}

	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("Test is skipped :" + result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
}
