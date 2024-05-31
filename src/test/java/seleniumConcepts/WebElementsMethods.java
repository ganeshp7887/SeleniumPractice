package seleniumConcepts;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import seleniumConcepts.initDriver;

public class WebElementsMethods {
	
	static private String usernameXpath = "//input[@class='input' and @name='username']";	// Find Elements by Xpath
	static private String passwordXpath = "//input[@class='input' and @name='password']";	// Find Elements by Xpath	
	static private String submitXpath = "//input[@class='button' and @type='submit']";		// Find Elements by Xpath
	static private String forgetXpath = "//*[contains(text(),'Forgdo')]";					// Find Elements by Xpath
	static private String labels =  "//ul[@class='leftmenu']/li";
	
	public static WebElement elementFound(WebDriver driver , String element) throws NoSuchElementException{
		WebElement ele = driver.findElement(By.xpath(element));
		return ele;
	}
	
	
	public static void main(String[] args) {
		initDriver init = new initDriver();
		WebDriver driver = init.initDriver();
		init.setUrl();
		
		List<WebElement> bo = driver.findElements(By.xpath(labels));		// findElements used to find all the elements matching
	
		for(WebElement aa : bo) {
			System.out.println("The menu contains :\t"+aa.getText());
		}
		
		WebElement username = elementFound(driver, usernameXpath);	// Find Elements by Xpath
		WebElement password = elementFound(driver, passwordXpath);
		WebElement submit =   elementFound(driver, submitXpath);
		WebElement forgot =	  elementFound(driver, forgetXpath);
		
		
		System.out.println("The username is displayed :\t"+username.isDisplayed());  						// WebElement Method 		
		System.out.println("The username is enabled :\t"+username.isEnabled());  	 						// WebElement Method
		System.out.println("The username is selected :\t"+username.isSelected());  							// WebElement Method
		System.out.println("The username is tag is :\t"+username.getTagName());  	 						// WebElement Method
		System.out.println("The username is name attribute is :\t"+username.getAttribute("name"));  		// WebElement Method
		username.sendKeys("ganesh"); 											   	 						// WebElement Method
		
		System.out.println("The password is displayed :\t"+password.isDisplayed());   						// WebElement Method
		System.out.println("The password is enabled :\t"+password.isEnabled());  	  						// WebElement Method
		System.out.println("The password is selected :\t"+password.isSelected());	  						// WebElement Method		
		password.sendKeys("ganesh");
		
		System.out.println("The submit is displayed :\t"+submit.isDisplayed());   							// WebElement Method
		System.out.println("The submit is enabled :\t"+submit.isEnabled());   	   							// WebElement Method
		System.out.println("The submit is selected :\t"+submit.isSelected());     							// WebElement Method
		System.out.println("The submit text is  :\t"+username.getText());      								// WebElement Method	 
		
		System.out.println("The forgot password text is  :\t"+forgot.getText());    						// WebElement Method
		System.out.println("The forgot password tag is  :\t"+forgot.getTagName());   						// WebElement Method
		System.out.println("The forgot password attribute is  :\t"+forgot.getAttribute("href"));   			// WebElement Method
		
		submit.click();
		
		if(driver != null) {
			driver.quit();
		}
	}
}
