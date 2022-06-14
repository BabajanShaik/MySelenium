package verificationsReportings;

import launch.RootTest;

public class Reporting extends RootTest
{

	public static void main(String[] args) throws Exception
	{
		
		initiate();
		test = rep.createTest("Reporting");
		//test.log(Status.INFO, "Initiate the Properties files...");
		logInfo("Initiate the Properties files...");
		
		launch("chromebrowser");
		//test.log(Status.INFO, "Opening the Browser:-"+d.getProperty("chromebrowser"));
		logInfo("Opening the Browser:-"+d.getProperty("chromebrowser"));
		
		naviagteUrl("amazonurl");
		//test.log(Status.INFO, "Navigating to Application:-"+childprop.getProperty("amazonurl"));
		logInfo("Navigating to Application:-"+childprop.getProperty("amazonurl"));
		
		String expectedLink = "Customer Servic";
		
		if(isLinkEqual(expectedLink))
		{
			reportSuccess("Both links are  equal...");
			
		}
		else
		{
			
			reportFailure("Both links are not equal...");
			
		}
		rep.flush();
	}

}
