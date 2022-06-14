package testNGAssertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertDEmo 
{
  @Test
  public void f() 
  {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in/");
	  
	  String expectedTitle = "Onli Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	  String actualTitle = driver.getTitle();
	  
	  //***********************Soft Assert*************************
	  
	  SoftAssert s = new SoftAssert();
	  //s.assertEquals(actualLink, expectedLink);
	  s.assertTrue(actualTitle.equals(expectedTitle), "Both Titles are not Same");	  
	  
	  s.assertTrue(false, "error1");
	  
	  s.assertTrue(false, "error2");
	  
	  s.assertTrue(true, "error3");
	  
	  s.assertTrue(false, "error4");
	  
	  driver.findElement(By.linkText("Customer Service")).click();
	  
	  s.assertAll();
	  
	  
  }
}
