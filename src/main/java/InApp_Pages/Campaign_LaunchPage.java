package InApp_Pages;

import org.openqa.selenium.WebDriver;

public class Campaign_LaunchPage extends BaseClass

{
	public Campaign_LaunchPage(WebDriver driver) 
	{
		super(driver);
	}
	public static final String campName = "//input[@id='Inapp edit message settings form.name']";
	public static final String broadcast = "//select//option[contains(text(),'Broadcast')]";
	public static final String mobileapp = "//select//option[contains(text(),'In-App QA App')]')]";
	public static final String saveanddraft = "//button[contains(text(), 'Save As Draft')]";
	public static final String contentcreation = "//a[contains(text(), ' Content Creation ')]";
	public static final String scheduling = "//a[contains(text(), 'Scheduling')]";
	public static final String saveandlunch = "//button[contains(text(), 'Save and Launch')]";

	public void launchCampaign() {
		setText(byXpath(campName), "Automation Task");
		//click(byXpath(source));
		click(byXpath(broadcast));
		//click(byXpath(save));
		waitForPageLoad();
		click(byXpath(mobileapp));
		click(byXpath(saveanddraft));
		waitForPageLoad();
		click(byXpath(contentcreation));
		waitForPageLoad();
		click(byXpath(saveanddraft));
		waitForPageLoad();
		click(byXpath(scheduling));
		waitForPageLoad();
		click(byXpath(saveanddraft));
		waitForPageLoad();
		click(byXpath(saveandlunch));
	}
}
