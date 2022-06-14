package autoit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloadUsingOptions 
{

	public static void main(String[] args) throws Exception 
	{
		//https://src.chromium.org/viewvc/chrome/trunk/src/chrome/common/pref_names.cc?revision=291266
		//https://chromium.googlesource.com/chromium/src/+/HEAD/chrome/common/chrome_switches.cc
		// http://kb.mozillazine.org/About:config_entries
		
		String fileType = "PDF";
		WebDriver driver;
		
		//For Chrome Browser
		
		/*WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 7");
		
		HashMap<String, Object> pref = new HashMap<String, Object>();
		pref.put("plugins.always_open_pdf_externally", true);
		pref.put("profile.managed_default_content_settings.javascript", 2);
		pref.put("download.default_directory", "C:\\Users\\user\\Desktop\\FileTypesDownload");
		options.setExperimentalOption("prefs", pref);
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://file-examples.com/");*/
		
		//For Edge Browser
		
		//WebDriverManager.edgedriver().setup();
		/*System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\Desktop\\Browser Drivers\\msedgedriver.exe");
		EdgeOptions options1 = new EdgeOptions();
		options1.addArguments("user-data-dir=C:\\Users\\user\\AppData\\Local\\Microsoft\\Edge\\User Data\\Default");
		
		HashMap<String, Object> pref1 = new HashMap<String, Object>();
		pref1.put("plugins.always_open_pdf_externally", true);
		pref1.put("download.default_directory", "C:\\Users\\user\\Desktop\\FileTypesDownload");
		options1.setExperimentalOption("prefs", pref1);
		
		driver = new EdgeDriver(options1);
		driver.manage().window().maximize();
		driver.get("https://file-examples.com/");*/
		
		//For Firefox Browser
		
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions option = new FirefoxOptions();
		
		ProfilesIni p = new ProfilesIni();
		FirefoxProfile profile = p.getProfile("SelFfProfile");
				
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		profile.setPreference("browser.download.dir", "C:\\Users\\user\\Desktop\\FileTypesDownload");
		profile.setPreference("browser.download.folderList", 2);
		option.setProfile(profile);
		
		
		
		driver = new FirefoxDriver(option);
		//To Block The Ads
		option.addPreference("javascript.enabled", false);
		
		driver.manage().window().maximize();
		driver.get("https://file-examples.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//h3[text()='Documents']//following-sibling::a")).click();
		Thread.sleep(4000);
		//driver.findElement(By.linkText("Sample documents")).click();
		driver.findElement(By.xpath("//td[text()='"+fileType+"']//following-sibling::td[2]/a")).click();
		driver.findElement(By.xpath("//a[starts-with(text(),'Download sample')]")).click();
	}

}
