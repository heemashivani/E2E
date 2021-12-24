package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


//import Pageresources.Forgotpassword;
import Pageresources.Landingpage;
import Pageresources.Loginpage;
import resources.base;

public class LoginpageValidation extends base
{
	public WebDriver driver;
	
	public static Logger log=LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void intilize() throws IOException
	{
		driver=intializeDriver();
		log.info("Driver intilized");
	}

	//@SuppressWarnings("unused")
	@Test(dataProvider="getData")
	public void loginValidation(String Email, String Password, String text) throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Landingpage po = new Landingpage(driver);
		Loginpage lp =po.clicklogin();
		lp.Email().sendKeys(Email);
		lp.Password().sendKeys(Password);
		lp.Login().click();
		System.out.println(text);
		log.info("Sucessfully logged in using given data");
	/*	lp.clickforgotPassword().click();

		Forgotpassword fp =new Forgotpassword(driver); 		
		fp.email().sendKeys("heema@gdf.ovm");
		fp.Next().click();*/
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		
		data[0][0] = "nonrestricteduser@gr.com";
		data[0][1] = "12345";
		data[0][2] = "Non Restricted User";
			
		data[1][0] = "restricteduser@gr.com";
		data[1][1] = "67892";
		data[1][2] = "Restricted User";
		
		return data;
	}
}
