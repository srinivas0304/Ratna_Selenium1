package captureScreenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import screenshotLibrary.Utility;


public class Screenshot_Capture 
{
		WebDriver driver;
		@Test
		public void captureScreenshot() throws Throwable
		{
			System.setProperty("webdriver.edge.driver", "C:\\Selenium\\Drivers\\msedgedriver.exe");
		    driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://facebook.com");
			WebElement userName=driver.findElement(By.xpath("//input[@id='email']"));
			userName.sendKeys("faf abd");
			//setup screenshot script
			Utility.captureScreenshot(driver, "TypeUserName");
			
			WebElement password=driver.findElement(By.id("pass"));
			password.sendKeys("Sri@99025");
			
			Utility.captureScreenshot(driver, "TypePassword");
			
			WebElement login=driver.findElement(By.name("login"));
			login.click();
			
			Utility.captureScreenshot(driver, "login");
			//driver.quit();
			
			
		}
		
		@AfterMethod
		
		public void tearDown(ITestResult result)
		{
			if(ITestResult.SUCCESS==result.getStatus())
			{
				Utility.captureScreenshot(driver,result.getName());
			}
			//driver.quit();
		}
	}

