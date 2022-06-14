package launch;

public class TC005 extends RootTest
{

	public static void main(String[] args) throws Exception 
	{
		initiate();
		
		launch("chromebrowser");
		
		naviagteUrl("amazonurl");
		
		selectOption("amazondropbox_id","Books");
		
		typeText("amazonsearchtextbox_id","Harry Potter");
		
		clickElement("amazonsearchbutton_xpath");
		
		
		
		//WebElement loc = driver.findElement(By.id("searchDropdownBox"));
		//loc.sendKeys("Books");
				
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
				
		//driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
				
	}

	

}
