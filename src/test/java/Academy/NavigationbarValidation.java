package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageresources.Landingpage;

import resources.base;

public class NavigationbarValidation extends base
{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void intilize() throws IOException
	{
		driver=intializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
		
	
	
	@Test
	public void navigationbarValidation() throws IOException, InterruptedException
	{	
		Landingpage po = new Landingpage(driver);
		
		Assert.assertTrue(po.Link().isDisplayed());
		log.info("Navigation bar is validated");
	
	}

	@AfterTest
	public void close()
	{
		driver.close();
	}
	
}
