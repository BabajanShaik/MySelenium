package launch;

public class TC002 extends RootTest
{

	public static void main(String[] args) throws Exception 
	{
		initiate();
		
		launch("chromebrowser");
		
		naviagteUrl("amazonurl");
		
	}

}
