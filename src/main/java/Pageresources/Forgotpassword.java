package Pageresources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forgotpassword
{

	public Forgotpassword(WebDriver driver)
	{
		this.driver = driver;
	}


	public WebDriver driver;
	
	By email      = By.cssSelector("#email");
	By next		  = By.xpath("//input[@value='Next']");
	
	
	
	public WebElement email()
	{
		return driver.findElement(email);

	}
	
	public WebElement Next()
	{
		return driver.findElement(next);

	}
	
}
