package launch;

public class TC003 extends RootTest
{

	public static void main(String[] args) throws Exception 
	{
		initiate();
		
		launch("chromebrowser");
		
		naviagteUrl("iciciurl");
	}

}
