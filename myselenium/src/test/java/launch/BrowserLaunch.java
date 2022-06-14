package launch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch 
{

	public static void main(String[] args) 
	{
		//First Approach using web driver manager
		
		/*WebDriverManager.chromedriver().setup();	//automatically loads the Chrome browser.
		ChromeDriver driver = new ChromeDriver(); 	//creating object for Chrome driver class.
		
		WebDriverManager.firefoxdriver().setup();		//automatically loads the FireFoxBrowser browser.
		FirefoxDriver driver1 = new FirefoxDriver();*/ 	//creating object for FireFoxBrowser.
		
		//Second Approach using system.setproperty
		
		/*System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\Browser Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver","C:/Users/user/Desktop/Browser Drivers/geckodriver.exe");
		FirefoxDriver driver1 = new FirefoxDriver();*/
		
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://amazon.in");
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.navigate().to("https://www.bestbuy.com");
		
	}
}
