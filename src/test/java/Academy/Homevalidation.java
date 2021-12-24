package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
//import org.apache.logging.log4j.core.config.Loggers;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageresources.Landingpage;
import resources.base;

public class Homevalidation extends base
{
	public WebDriver driver;
	Landingpage po;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void intilize() throws IOException
	{
		driver=intializeDriver();
		log.info("Driver intilized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to HomePage");
		driver.manage().window().maximize();
	}
	
	@Test
	public void homepageTextValidation() throws IOException, InterruptedException
	{
	
		po = new Landingpage(driver);
		System.out.println(po.Title().getText());
		Assert.assertEquals(po.Title().getText(),"Featured 123 Courses");
		log.info("Sucessfully validated text message");
		//po.clicklogin().click();
		System.out.println(po.Text().getText());
	}
	
	@Test
	public void homepageText() throws IOException, InterruptedException
	{
	
		po = new Landingpage(driver);
		Assert.assertEquals(po.Text().getText(),"World class Tutorials on Selenium, Rest Assured, Protractor, SoapUI, Appium, Cypress, Jmeter, Cucumber, Jira and many more!");
		System.out.println(po.Text().getText());
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	

	

}
