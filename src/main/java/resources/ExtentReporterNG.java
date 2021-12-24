package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG
{

	static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Heema Shivani");
		
		return extent;
				
	}
	
	@Test
	public void intialDemo()
	{
	
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/#/index");
		
		System.out.println(driver.getTitle());
		driver.close();
	}
	
}
