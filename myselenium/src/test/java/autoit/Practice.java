package autoit;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice 
{

	public static void main(String[] args) 
	{
		String fileType = "DOC, DOCX";
		WebDriver driver;
		
		//For Chrome Browser
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> pref = new HashMap<String, Object>();
		
		//To download the PDF directly.
		pref.put("plugins.always_open_pdf_externally", true);
		//To Block Ads
		pref.put("profile.managed_default_content_settings.javascript", 2);
		//To save the file in selected destination.
		pref.put("download.default_directory", "C:\\Users\\user\\Desktop\\FileTypesDownload");
		options.setExperimentalOption("prefs", pref);
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://file-examples.com/");
		
		//driver.findElement(By.xpath("//h3[text()='Documents']//following-sibling::a")).click();
		driver.findElement(By.linkText("Sample documents")).click();
		driver.findElement(By.xpath("//td[text()='"+fileType+"']//following-sibling::td[2]/a")).click();
		driver.findElement(By.xpath("//a[starts-with(text(),'Download sample')]")).click();
	}

}
