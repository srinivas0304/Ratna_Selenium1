package extentreports;

import java.util.concurrent.TimeUnit;

import javax.management.openmbean.OpenMBeanAttributeInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import browsers.ChromeBrowser;
import extentLibrary.Extent_Utility;


public class OrangeHrm_Extent
{
	WebDriver driver;
	
	@BeforeTest
	public void setUpTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");
		
		driver=new ChromeDriver();
	}
	
	@Test
	public void orange()
	{
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123",Keys.ENTER);
		
		Extent_Utility.extentReport(driver, "OpenOrangeHrm");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(ITestResult.SUCCESS==result.getStatus())
		{
			Extent_Utility.extentReport(driver, result.getName());
		}
		//driver.quit();
	}
}
