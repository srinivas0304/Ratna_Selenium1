package testcases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import data_utility.*;
public class tc_PimSearch extends BaseClass
{
	@Test(description = "This testcase will search employee")
	
	public void tc() throws Exception
	{
		driver.findElement(By.xpath("//b[text()='PIM']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("empsearch_employee_name_empName")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(pf.getExcel("Sheet1", 0, 0));
	}
}