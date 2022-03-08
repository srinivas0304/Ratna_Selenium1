package data_utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import properties.Properties_Fetch;

public class BaseClass 
{
	public WebDriver driver;
	public Properties_Fetch pf = new Properties_Fetch();

	@BeforeClass(description = "From this step it will open the browser")
	public void openBrowser() 
	{
		System.setProperty("webdriver.edge.driver", "C:\\Selenium\\Drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeMethod(description = "From this step it will login to the page")
	public void login() throws Exception 
	{
		driver.get(pf.note("url"));
		driver.findElement(By.id("txtUsername")).sendKeys(pf.note("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(pf.note("password"), Keys.ENTER);

	}

	@AfterMethod(description = "From this step it will logout")
	public void logout() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.close();
	}

}
