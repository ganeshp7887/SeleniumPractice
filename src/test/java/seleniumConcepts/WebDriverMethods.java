package seleniumConcepts;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;


public class WebDriverMethods {

	public static void main(String[] args) {
	
		initDriver init = new initDriver();
		
		WebDriver driver = init.initDriver();
		
		init.setUrl();
		
		driver.findElement(By.xpath("//a[text()='www.parasoft.com']")).click();
		
		// driver.get("");										 // Webdriver methods :- To navigate to url.
		
		String url = driver.getCurrentUrl(); 					 // Webdriver methods :- To Get current url location.
		
		String pageSource = driver.getPageSource(); 			 // Webdriver methods :- To get complete web page.
		
		String title = driver.getTitle(); 						 // Webdriver methods :- To get web page title.
		
		String windowID = driver.getWindowHandle();  			 // Webdriver methods :- To get id of currently working window.
		
		Options manage = driver.manage(); 						 // Webdriver methods :- To perform web page operations like cookies, timeouts, and windows maximize, minimize.
		
		Navigation nav = driver.navigate(); 					 // Webdriver methods :- To navigate web page forward backward or to move to url.
		
		TargetLocator switches = driver.switchTo(); 			 // Webdriver methods :- To perform operations on alerts, frames and windows.
		
		Set<String> wn = driver.getWindowHandles();    			 //	Webdriver methods :- To get list of windows on current sessions
		
		System.out.println("The url is : \t"+url);
		System.out.println("the page source is : \t"+pageSource);
		System.out.println("the title  is : \t"+title);
		System.out.println("the window id  is : \t"+windowID);
		
		
		for (String ss : wn) {
			System.out.println("the windows in current :\t"+ss);
		}
		if(driver != null) {
			driver.quit();
		}
	}
}
