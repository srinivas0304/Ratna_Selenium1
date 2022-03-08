package extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Demo_Extent 
{
	public static void main(String[] args) 
	{
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/demo.html");
		
		ExtentReports extent=new ExtentReports();
		
		extent.attachReporter(reporter);
		
		ExtentTest logger=extent.createTest("Login_demo");
		
		logger.log(Status.INFO, "Logi to demo site");
		
		logger.log(Status.PASS, "Title verified");
		
		extent.flush();
		
				
		System.out.println("Login to demosite");
		
		
		
	}
}
