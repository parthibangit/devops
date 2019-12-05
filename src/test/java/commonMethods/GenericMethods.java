package commonMethods;

//maually imported a config file reader class as static
import static commonUtility.PropertyReader.getValue;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class GenericMethods 
{
	
	public static WebDriver driver;
	
	public GenericMethods(WebDriver driver)
	{
		GenericMethods.driver=driver;
		//PageFactory.initElements(driver, LoginPage.class);
	}
	

	public void openBrowser() throws Exception
	{
		switch (getValue("browser")) 
		{
		   case "Firefox":
			System.setProperty("", getValue("driverpath"));
			driver=new FirefoxDriver();
			break;
			
		   case "chrome":
			System.setProperty("webdriver.chrome.driver", getValue("driverpath"));
			driver=new ChromeDriver();
			break;

		   default:
			System.out.println("Something happened - Browser not opened");
			
			break;
		}
		
		driver.get(getValue("URL"));
		driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	
	
	
	public void enterLoginDetails(By userName, By password, String userValue, String pwdValue)
	{
		driver.findElement(userName).sendKeys(userValue);
		driver.findElement(password).sendKeys(pwdValue);
		//driver.findElement(button).click();
	}
	
	public void enterLoginDetails(WebElement userXpath, WebElement pwdXpath, WebElement button, String userValue, String pwdValue)
	{
		driver.findElement((By) userXpath).sendKeys(userValue);
		driver.findElement((By) pwdXpath).sendKeys(pwdValue);
		//driver.findElement((By) button).click();
	}
	
	public void buttonClick(By butXpath) throws Exception
	{
		driver.findElement(butXpath).click();
	}
	
	public void switchToView(By lightXpath)
	{
		driver.findElement(lightXpath).click();
	}
	
	public static void tabClick(By tabXpath, String pageName)
	{
		List<WebElement> tabs=driver.findElements(tabXpath);
		
		for(WebElement tabValue:tabs)
		{
			String tabText=tabValue.getText();
			if(tabText.equalsIgnoreCase(pageName))
			{
				tabValue.click();
				break;
			}
		}
	}
	
	public void clickTab(By tabXpath, String pageName) throws InterruptedException
	{
		
		switch (pageName) 
		{
		   case "Lead/Referral": 	
			tabClick(tabXpath, pageName);
			break;
			
         case "Customer/Prospects": 
         tabClick(tabXpath, pageName);
			break;
			
         case "Book Of Business(New)": 
         tabClick(tabXpath, pageName);
   		break;
   		
         case "Campaigns": 
         Thread.sleep(2000);
         tabClick(tabXpath, pageName);
      	break;

		   default:
			break;
		}
		
	}
	
	public String takeScreenshot(String shotName) throws Exception
	{
		
		
		TakesScreenshot tc= ((TakesScreenshot)driver);
		File source = tc.getScreenshotAs(OutputType.FILE);
		String destination=getValue("screenshotpath");
		File dest=new File(destination + shotName + ".png");
		FileHandler.copy(source, dest);
		return destination;
		
	}
			
	
}
