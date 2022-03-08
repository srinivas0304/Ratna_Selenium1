package crossBrowsing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerifyBrowser
{
	WebDriver driver;

	@Test

	@Parameters("browser")

	public void edgeSetup(String browser) throws Throwable
	{
	if(browser.equalsIgnoreCase("edge"))
	{
	System.setProperty("webdriver.edge.driver", "C:\\Selenium\\Drivers\\new edge\\msedgedriver.exe");
	driver=new EdgeDriver();
	driver.get("https://www.amazon.in/");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nokia",Keys.ENTER);
	Thread.sleep(1000);
	List<WebElement> ele=driver.findElements(By.xpath("//span[contains(text(),'Nokia')]"));
	Thread.sleep(1000);
	List<WebElement> ele1=driver.findElements(By.xpath("//span[contains(text(),'Nokia')]/../../../..//div//div//div//div//div//a"));

	for(int i=0;i<ele.size()-1;i++)
	{
	System.out.println(ele.get(i).getText()+": "+ele1.get(i).getText());
	}

	}
	else if(browser.equalsIgnoreCase("chrome"))
	{
	System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\Drivers\\\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList");
	}

	else if(browser.equalsIgnoreCase("ff"))
	{
	System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Drivers\\geckodriver\\geckodriver.exe");
	driver=new FirefoxDriver();
	driver.get("https://www.worldometers.info/coronavirus");
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
