package resources;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base 
{
	public WebDriver driver;
	public Properties prop;
	@SuppressWarnings("deprecation")
	public WebDriver intializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fil = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fil);
		//String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if( browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			if(browserName.contains("headless"))
				{
					option.addArguments("headless");
				}
			driver = new ChromeDriver(option);
			
		}
		
		else if( browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");	
			driver=new FirefoxDriver();
		}
	
		else if( browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\IEDriverServer.exe");	
			driver=new InternetExplorerDriver();
		}
	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenshot(String testcaseName,WebDriver driver)  throws IOException
	{
		TakesScreenshot ss= (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source, new File(destFile));
		
		return destFile;
	}
	
}
