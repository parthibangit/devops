package xpathCollectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage 
{
	

	
	//public By userName=By.id("username");
	public By userName=By.id("username");
	public By password=By.id("password");
	public By button=By.id("Login");
	public By switchLight=By.className("switch-to-lightning");
	public By customerTabXpath=By.xpath("//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none']//a[@class='slds-context-bar__label-action dndItem']");
	
	
	@FindBy(how=How.ID, using="username" )
	public WebElement userXpath;
	
	@FindBy(how=How.ID, using="password" )
	public WebElement passXpath;

	@FindBy(how=How.ID, using="Login" )
	public WebElement buttXpath;
	
   public String userData="divya.kumar1@usbank.com.uatest";
   public String passData="Nov@2019";
	
	
}
