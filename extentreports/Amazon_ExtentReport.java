package extentreports;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Amazon_ExtentReport 
{
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	WebDriver driver=null;

	@BeforeSuite
	public void setUpExtentReport() 
	{
		
	htmlReporter = new ExtentHtmlReporter("./Reports/Amazom_extent3.html");
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
	}

	@BeforeTest
	public void setUpTest() 
	{

	System.setProperty("webdriver.edge.driver", "C:\\Selenium\\Drivers\\msedgedriver.exe");
	driver = new EdgeDriver();
	
	}
	
		@Test
		public void amazon() throws Exception
		{	
		ExtentTest test = extent.createTest("FirstTestcase");
		
		test.log(Status.INFO, "FirstTestcase");
		test.log(Status.PASS, "FirstTestcase");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nokia",Keys.ENTER);
		}
		@Test
		public void coronavirus()
		{
			ExtentTest test = extent.createTest("SecondTestcase");
			test.log(Status.INFO, "SecondTestcase");
			test.log(Status.PASS, "SecondTestcase");
		
			System.setProperty("webdriver.edge.driver", "C:\\Selenium\\Drivers\\msedgedriver.exe");
			WebDriver driver=new EdgeDriver();	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("https://www.worldometers.info/coronavirus");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String s=driver.findElement(By.xpath("//h1[text()='Coronavirus Cases:']/..//div")).getText();
			System.out.println("Coronavirus Cases: "+s);
			String s1=driver.findElement(By.xpath("//h1[text()='Recovered:']/..//div")).getText();
			System.out.println("Recovered: "+s1);
		}
		
		@AfterTest
		public void close() 
		{
			
		System.out.println("Test Completed Successfully");

		}
		
		@AfterSuite
		public void flush() 
		{
		extent.flush();
		}
}
