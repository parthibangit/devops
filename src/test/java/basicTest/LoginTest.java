package basicTest;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import static commonUtility.Screenshot.*;
import commonMethods.GenericMethods;
import xpathCollectors.LoginPage;
import static commonUtility.JsonReader.*;


public class LoginTest extends LoginPage
{

	
	static WebDriver driver;
	GenericMethods methods;
	
	
	@Test(priority=0)
	public void test1() throws Exception 
	{
		
		methods=new GenericMethods(driver);
		methods.openBrowser();
		
	}
	
	@Test(priority=1)
	public void test2() throws Exception
	{
		System.out.println("Test 1 started");
		
		
		methods.enterLoginDetails(userName, password,jsonReader("username").toString(), jsonReader("password").toString());
		takeScreenshot(GenericMethods.driver, "Test2");
		methods.buttonClick(button);
		//methods.takeScreenshot("Login Test");
		Thread.sleep(2000);
		//takeScreenshot(GenericMethods.driver, "Test2");
		System.out.println("Test 1 completed");
		
	}

	@Test(priority=2)
	public void test3() throws InterruptedException
	{
		System.out.println("Test 2 started");
		methods.clickTab(customerTabXpath, "Campaigns");
		System.out.println("Test 2 Completed");
		//driver.quit();
	}
	
}
