package screenshotLibrary;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import captureScreenshot.Screenshot_Capture.*;

public class Utility 
{
	
	
	public static void captureScreenshot(WebDriver driver, String screenshotName)
	{
		try
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshot/"+screenshotName+".jpg"));
			System.out.println("screenshot taken");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception while taking screeshot: "+e.getMessage());
		}
	}
}
