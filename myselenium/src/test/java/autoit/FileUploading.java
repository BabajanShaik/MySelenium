package autoit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploading 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://transfer.pcloud.com/");
		driver.findElement(By.linkText("Click here to add files")).click();
		
		//To include the .exe file we have a execute method that is the static method called by a class name.
		
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\user\\Desktop\\fu.exe");
		
	}

}
