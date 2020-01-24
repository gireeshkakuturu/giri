package InApp_Pages;

import org.openqa.selenium.WebDriver;

public class CampaignPage extends BaseClass
{
	public WebDriver driver = null;
	
	public CampaignPage(WebDriver driver)
	{
		super(driver);
		
	}
	public static final String inAppFrame = "//iframe[contains(@class,'integration')]";
	public static final String inApptext = "//span[contains(text(),'In-app')]";
	public static final String createNewCamp = "//*[contains(@href,'/inapp-campaigns/new')]";

	public void createNew() 
	{

		switchToIframe(byXpath(inAppFrame));

		click(byXpath(inApptext));
		
		waitForPageLoad();
		click(byXpath(createNewCamp));
		waitForPageLoad();		
	}
}
