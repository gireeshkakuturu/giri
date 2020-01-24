package InApp_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseClass 
{
	public WebDriver driver = null;
	protected BaseClass() { this.driver = initialization(); }
	protected BaseClass(WebDriver driver) { this.driver = driver; }

	private WebDriver initialization()
	{
		String path = "C:\\Users\\user\\Downloads\\chromedriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	public void navigateToUrl(String url) {
		driver.get(url);
	}

	public void waitForPageLoad()
	{
		new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
        ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	}
	public By byXpath(String xpath)
	{
		
		return By.xpath(xpath);
	}	
	public By byLink(String linkText) 
	{
		
		return By.partialLinkText(linkText);
	}	
	public void hover(By xpath)
	{
		Actions mouseAction = new Actions(driver);
		WebElement element = driver.findElement(xpath);
		mouseAction.moveToElement(element);		
	}

	public void switchToIframe(By xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(xpath));
	}
	public void waitUntilFound(By xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
	}

	public void waitUntilClickable(By xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(xpath));
	}

	public void clickUsingJS(String CSS)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementByCSS('"+CSS+"').click();");
	}
	public void click(By xpath) 
	{
			try 
			{
				waitUntilClickable(xpath);
				Thread.sleep(100);
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			driver.findElement(xpath).click();	
	}	
	public void setText(By xpath, String value)
	{		waitUntilFound(xpath);
			driver.findElement(xpath).sendKeys(value);
		
	}	
}
