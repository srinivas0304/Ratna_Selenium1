package fileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FileUpload_SendKeys
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.edge.driver", "C:\\Selenium\\Drivers\\msedgedriver.exe");
		EdgeDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.monsterindia.com/seeker/registration");
		Thread.sleep(2000);
		WebElement upload=driver.findElement(By.xpath("//span[text()='Choose CV']"));
		Thread.sleep(1000);
		upload.sendKeys("C:\\Srinivas\\rich.txt");
		System.out.println("File upload succesfully");

	}
}
