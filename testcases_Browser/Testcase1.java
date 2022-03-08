package testcases_Browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import crossBrowser.SetUp_Browser.*;

public class Testcase1 
{
	WebDriver driver;
	@Test
	public void amazon() throws Exception
	{
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
	
	
}
