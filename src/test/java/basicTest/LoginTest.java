package basicTest;



import static commonUtility.JsonReader.jsonReader;
import static commonUtility.Screenshot.takeScreenshot;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import commonMethods.GenericMethods;
import xpathCollectors.LoginPage;


public class LoginTest extends LoginPage
{

	
	static WebDriver driver;
	GenericMethods methods;
	
	
	@Test(priority=0)
	public void test1() throws Exception 
	{
		
		methods=new GenericMethods(driver);
		methods.openBrowser("it");
		
	}
	
	@Test(priority=1)
	public void test2() throws Exception
	{
		System.out.println("Test 1 started");
		
		methods.enterLoginDetails(userName, password,jsonReader("username", "itlogin"), jsonReader("password", "itlogin"));
		takeScreenshot(GenericMethods.driver, "Test2");
		methods.buttonClick(button);	
		Thread.sleep(2000);
		
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
