package brokenLinks;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.javascript.host.URL;

public class VerifyLinks {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://stackoverflow.com/");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.addAll((Collection<? extends WebElement>) driver.findElements(By.tagName("img")));

		List<WebElement> activeLinks = new ArrayList<WebElement>();

		System.out.println("Total Links and Images are: " + links.size());

		for (int i = 0; i < links.size(); i++) 
		{
			System.out.println(links.get(i).getAttribute("href"));
			if (links.get(i).getAttribute("href") != null && links.get(i).getAttribute("href").contains("javascript")) {
				activeLinks.add(links.get(i));
			}
		}

		System.out.println("Total Active links are: " + activeLinks.size());
		//check href url with httpconnection api:
		
		for (int j = 0; j < activeLinks.size(); j++) 
		{
		    HttpURLConnection connection=(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
		}

	}

}