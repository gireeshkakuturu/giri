package InApp_Pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends BaseClass
{
	//public static WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	// Home - Login Page
	public static final String account = "//*[@id='company']";
	public static final String userName = "//*[@id='username']";
	public static final String password = "//*[@id='password']";
	public static final String loginButton = "//*[@id='loginButton']";

	public void login()
	{		
		setText(byXpath(account),"MEQA_Candidates");
		setText(byXpath(userName),"Gireesh");
		setText(byXpath(password),"Interview2020!");
		click(byXpath(loginButton));
		//return new DashboardPage(driver);
	}

}

