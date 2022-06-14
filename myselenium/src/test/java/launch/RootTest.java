package launch;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RootTest 
{
	public static WebDriver driver;
	public static String projectpath =System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties d;
	public static Properties mainProp;
	public static Properties childprop;
	public static Properties orProp;
	public static ExtentReports rep;
	public static ExtentTest test;
	public static String filePath;
	
	static
	{
		Date dt = new Date();
		filePath = dt.toString().replace(':', '_').replace(' ', '_');
		
	}
	
	public static void initiate() throws Exception
	{
		fis = new FileInputStream(projectpath+"/src/test/resources/environ.properties");
		mainProp = new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectpath+"/src/test/resources/"+e+".properties");
		childprop = new Properties();
		childprop.load(fis);
		String url = childprop.getProperty("amazonurl");
		System.out.println(url);
		
		fis = new FileInputStream(projectpath+"/src/test/resources/data.properties");
	    d = new Properties();
		d.load(fis);
		
		fis = new FileInputStream(projectpath+"/src/test/resources/or.properties");
		orProp = new Properties();
		orProp.load(fis);
		
		fis = new FileInputStream(projectpath+"/src/test/resources/log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		rep = ExtentManager.getInstance();
	}
	
		public static void launch(String browser)
	{
		if(browser.equals("chrome"))	//if(chrome.equals("chrome") or if(firefox.equals("firefox")
		{
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 7");
			option.addArguments("--disable-notifications");
		  /*option.addArguments("--start-maximized");
			option.addArguments("--ignore-certificate-errors-spki-list");
			option.addArguments("--proxy-server=https://192.168.101:9090");*/
			
			driver = new ChromeDriver(option);
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile profile = p.getProfile("SelFfProfile");	//to load user defined browser
			
			FirefoxOptions option = new FirefoxOptions();	//to set user defined browser
			option.setProfile(profile);
			
			//Handling Notifications
			
			profile.setPreference("dom.webnotifications.enabled", false);
			
			//Certificate Error Handling
		
			/*profile.setAcceptUntrustedCertificates(true);
			  profile.setAssumeUntrustedCertificateIssuer(false);*/
			
			//How to work with Proxy settings
			
			/*profile.setPreference("network.proxy.type", 1);
			  profile.setPreference("network.proxy.socks", "192.168.10.1");
			  profile.setPreference("network.proxy.socks_port", 1744);*/
			
			driver = new FirefoxDriver(option);
		}
	}
	
		public static void naviagteUrl(String urlkey)
		
		{
		//driver.get(urlkey);
		driver.navigate().to(childprop.getProperty(urlkey));
		driver.manage().window().maximize();
		}
		
		public static void selectOption(String locatorKey, String option) 
		
		{
			//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);
			getElement(locatorKey).sendKeys(option);
		}
		
		public static void typeText(String locatorKey, String text) 
		
		{
			//driver.findElement(By.name(orProp.getProperty(locatorKey))).sendKeys(text);
			getElement(locatorKey).sendKeys(text);;
		}
		
		public static void clickElement(String locatorKey) 
		
		{
			//driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();
			getElement(locatorKey).click();
		}
		
		public static WebElement getElement(String locatorKey) 
		
		{
			WebElement element = null;
			
			//Checking Whether element is present
			
			if(!isElementPresent(locatorKey))
				
			//Reporting Failure
			
			System.out.println("Element is not Present:"+locatorKey);
			
			element = driver.findElement(getLocator(locatorKey));
			
			/*if(locatorKey.endsWith("_id"))
			{
				element = driver.findElement(By.id(orProp.getProperty(locatorKey)));
			}
			else if(locatorKey.endsWith("_name"))
			{
				element = driver.findElement(By.name(orProp.getProperty(locatorKey)));
			}
			else if(locatorKey.endsWith("_classname"))
			{
				element = driver.findElement(By.className(orProp.getProperty(locatorKey)));
			}
			else if(locatorKey.endsWith("_xpath"))
			{
				element = driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
			}
			else if(locatorKey.endsWith("_css"))
			{
				element = driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
			}
			else if(locatorKey.endsWith("_linktest"))
			{
				element = driver.findElement(By.linkText(orProp.getProperty(locatorKey)));
			}
			else if(locatorKey.endsWith("_patiallinktest"))
			{
				element = driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey) ));
			}*/
			return element;
		}

		public static boolean isElementPresent(String locatorKey) 
		{
			System.out.println("Checking for Element Presence:"+locatorKey);
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			try 
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
				
				/*if(locatorKey.endsWith("_id"))
				{
					wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orProp.getProperty(locatorKey))));
				}
				
				else if(locatorKey.endsWith("_name"))
				{
					wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orProp.getProperty(locatorKey))));
				}
				else if(locatorKey.endsWith("_classname"))
				{
					wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orProp.getProperty(locatorKey))));
				}
				else if(locatorKey.endsWith("_xpath"))
				{
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orProp.getProperty(locatorKey))));
				}
				else if(locatorKey.endsWith("_css"))
				{
					wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orProp.getProperty(locatorKey))));
				}
				else if(locatorKey.endsWith("_linktest"))
				{
					wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orProp.getProperty(locatorKey))));
				}
				else if(locatorKey.endsWith("_patiallinktest"))
				{
					wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(orProp.getProperty(locatorKey))));
				}*/
			} 
			
			catch (Exception e) 
			
			{
				return false;
			}
			
			return true;
		}
		
		public static By getLocator(String locatorKey)
		{
			By by = null;
			
			if(locatorKey.endsWith("_id"))
			{
				by = By.id(orProp.getProperty(locatorKey));
			}
			else if(locatorKey.endsWith("_name"))
			{
				by = By.name(orProp.getProperty(locatorKey));
			}
			else if(locatorKey.endsWith("_classname"))
			{
				by = By.className(orProp.getProperty(locatorKey));
			}
			else if(locatorKey.endsWith("_xpath"))
			{
				by = By.xpath(orProp.getProperty(locatorKey));
			}
			else if(locatorKey.endsWith("_css"))
			{
				by = By.cssSelector(orProp.getProperty(locatorKey));
			}
			else if(locatorKey.endsWith("_linktest"))
			{
				by = By.linkText(orProp.getProperty(locatorKey));
			}
			else if(locatorKey.endsWith("_patiallinktest"))
			{
				by = By.partialLinkText(orProp.getProperty(locatorKey));
			}
			
			return by;
						
		}
		
		
		//***********************Verifications***********************
		
		public static boolean isLinkEqual(String expectedLink) 
		{
			String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
			if(actualLink.equals(expectedLink))
				return true;
			else
				return false;
		}
		
		//***********************Reportings***************************
		
		public static void logInfo(String logInformation) 
		{
			test.log(Status.INFO, logInformation );
			
		}
		
				
		public static void reportSuccess(String successMessage) 
		{
			test.log(Status.PASS, successMessage );
			
		}

		public static void reportFailure(String failureMessage) throws Exception 
		{
			test.log(Status.FAIL, failureMessage);
			WebElement actualLink = driver.findElement(getLocator("amazoncustomerservice_linktest"));
			//WebElement actualLink = driver.findElement(By.linkText("Customer Service"));
			highlightElement(driver, actualLink);
			takesScreenshot();
		}
		
		
		public static void highlightElement(WebDriver driver, WebElement element) 
		{
			JavascriptExecutor jsExecuter = (JavascriptExecutor)driver;
			
			jsExecuter.executeScript("arguments[0].setAttribute('style','border:2px solid red; background:green');",element);		
		}
		
		public static void takesScreenshot() throws Exception 
		{
			
			Date dt = new Date();
			System.out.println(dt);
			String dateFormat = dt.toString().replace(":", "_").replace(" ", "_")+".png";
			File scrnshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrnshotfile, new File(projectpath+"//failurescreenshots//"+dateFormat));
			
			logInfo("Screenshot---->"  +test.addScreenCaptureFromPath(projectpath+"//failurescreenshots//"+dateFormat));
		}
	}
