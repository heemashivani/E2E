package Pageresources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage
{
	
	public Landingpage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public WebDriver driver;
	
	By login = By.cssSelector("a[class='theme-btn register-btn']");
	By title = By.xpath("//div[@class='pull-left']");
	By links = By.cssSelector("ul[class='navigation clearfix']");
	By text	 = By.cssSelector("div[class='header-text hidden-xs'] h3");
	
	public Loginpage clicklogin()
	{
		driver.findElement(login).click();
		Loginpage lp=new Loginpage(driver);
		return lp;
	}
	
	public WebElement Title()
	{
		return driver.findElement(title);
	}
	
	public WebElement Text()
	{
		return driver.findElement(text);
	}
	
	public WebElement Link()
	{
		return driver.findElement(links);
	}
}
