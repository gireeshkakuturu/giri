package InApp_Pages;

import org.openqa.selenium.WebDriver;

public class DashboardPage extends BaseClass
{
	public DashboardPage(WebDriver driver)
	{
		super(driver);
	}
	public static final String campaignMenu = "//*[@id=\"main-menu-campaign-manager\"]";
	public static final String mobileEngage = "//*[@id=\"main-menu-sub-item-integration-push-notification\"]";

	public void selectMenu()
	{	
		click(byXpath(campaignMenu));
		click(byXpath(mobileEngage));
		waitForPageLoad();
	}	
}



