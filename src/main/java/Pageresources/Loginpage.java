package Pageresources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;

public class Loginpage
{


	public Loginpage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public WebDriver driver;
	
	By email 	  = By.cssSelector("input[id='email']"); 
	By password   = By.xpath("//input[@type='password']");
	By login 	  = By.name("commit");
	By forgotPass = By.xpath("//a[contains(text(),'Forgot Password')]");
	
	public WebElement Email()
	{
		return driver.findElement(email);
	}
	
	public WebElement Password()
	{
		return driver.findElement(password);
	}
	
	public WebElement Login()
	{
		return driver.findElement(login);
	}
	
	public WebElement clickforgotPassword()
	{
		return driver.findElement(forgotPass);
	}
	
	/*public void clickforgotPassword() 
	{
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(forgotPass)).click().build().perform();
		
	}*/
}
