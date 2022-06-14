package launch;

import org.apache.log4j.Logger;

public class TC007 extends RootTest
{

	private static final Logger log = Logger.getLogger(TC007.class);
	
	public static void main(String[] args) throws Exception 
	{
		initiate();
		log.info("Initiate the Properties Files....");
		
		launch("chromebrowser");
		log.info("Opening the Browser :-"+d.getProperty("chromebrowser"));
		
		naviagteUrl("amazonurl");
		log.info("Navigating to Application :"+childprop.getProperty("amazonurl"));
		
		selectOption("amazondropbox_id","Books");
		log.info("Selecting Option By Using Locator :"+orProp.getProperty("amazondropbox_id"));
		
		typeText("amazonsearchtextbox_id","Harry Potter");
		log.info("Typing Text Harry Potter By Using Locator : "+orProp.getProperty("amazonsearchtextbox_id"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on Element By Using Locator :"+orProp.getProperty("amazonsearchbutton_xpath"));
	}

}
