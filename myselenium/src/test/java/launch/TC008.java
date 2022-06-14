package launch;

import com.aventstack.extentreports.Status;

public class TC008 extends RootTest
{

	public static void main(String[] args) throws Exception 
	{
		initiate();
		test = rep.createTest("TC008");
		test.log(Status.INFO,"Initiate the Properties Files....");
		
		launch("chromebrowser");
		test.log(Status.PASS,"Opening the Browser :-"+d.getProperty("chromebrowser"));
				
		naviagteUrl("amazonurl");
		test.log(Status.INFO, "Navigating to Application :"+childprop.getProperty("amazonurl"));
				
		selectOption("amazondropbox_id","Books");
		test.log(Status.FAIL, "Selecting Option By Using Locator :"+orProp.getProperty("amazondropbox_id"));
				
		typeText("amazonsearchtextbox_id","Harry Potter");
		test.log(Status.INFO, "Typing Text Harry Potter By Using Locator : "+orProp.getProperty("amazonsearchtextbox_id"));
				
		clickElement("amazonsearchbutton_xpath");
		test.log(Status.INFO, "Clicked on Element By Using Locator :"+orProp.getProperty("amazonsearchbutton_xpath"));
		
		rep.flush();
	}

}
