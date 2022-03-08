package drynamicWebTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Dynamic_WebTable 
{
	@Test
	 public void dynamicWebTable()
	{
		System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\Drivers\\\\new edge\\\\msedgedriver.exe");
		EdgeDriver driver=new EdgeDriver();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		List<WebElement> rowElements=driver.findElements(By.xpath("//div[@id='leftcontainer']//table//tbody//tr//td[1]"));
				//driver.findElements(By.xpath("//a[contains(text(),'Corporation Bank')]/./../../../..//tbody//tr"));
		
		int rowSize=rowElements.size();
		System.out.println("Number of Row: "+rowSize);
		
		List<WebElement> columnElements=driver.findElements(By.xpath("//div[@id='leftcontainer']//table//thead//tr//th"));
				//driver.findElements(By.xpath("//a[contains(text(),'Corporation Bank')]/./../../../..//tbody//tr"));
		
		int columnSize=columnElements.size();
		
		System.out.println("Number of Columns: "+columnSize);
		
		
		
		  for(int i=1; i<=rowSize;i++)
		  { 
			  for(int j=1; j<=columnSize;j++) 
			  { 
				  String  s=driver.findElement(By.xpath("//div[@id='leftcontainer']//table//tbody//tr["+i+"]//td["+j+"]")).getText()+"  "; 
				  
				 // "//a[contains(text(),'Corporation Bank')]/./../../../..//tbody//tr["+i+"]//td["+j+"]
				  System.out.print(s);
			  }
			  System.out.println();
		}
		  
		 
	}
}
