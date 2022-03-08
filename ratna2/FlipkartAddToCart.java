package ratna2;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartAddToCart
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
				
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("nokia");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		driver.findElement(By.xpath("//a[text()='Nokia TA-1304/105 SS']")).click();
		
		String main=driver.getWindowHandle();
		
		Set<String> allId=driver.getWindowHandles();
		
		for(String i:allId)
		{
			if(!main.equals(i))
			{
			driver.switchTo().window(i);
			}
		}
		
		driver.switchTo().window(main);
		
		Set<String> child=driver.getWindowHandles();
		for(String s1:child)
		{
			driver.switchTo().window(s1);
		}
		
		WebElement ele=driver.findElement(By.id("pincodeInputId"));
		ele.sendKeys(Keys.CONTROL+"a");
		ele.sendKeys(Keys.DELETE);
		driver.findElement(By.id("pincodeInputId")).sendKeys("500027");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Check']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		driver.findElement(By.xpath("//button[text()='+']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='+']")).click();
		
		
		
	}
}
