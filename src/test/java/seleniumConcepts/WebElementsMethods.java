package seleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementsMethods {
	
	static public String usernameXpath = "//input[@name='uid']";	// Find Elements by Xpath
	static public String passwordXpath = "//input[@name='password']";	// Find Elements by Xpath	
	static public String submitXpath = "//input[@name='btnLogin']";		// Find Elements by Xpath
	static public String resetXpath = "//input[@name='btnReset']";					// Find Elements by Xpath
	static public String messageXpath = "//form[@name='frmLogin']/table/tbody/tr/td[1]";
	
	public static WebElement elementFound(WebDriver driver , String element) throws NoSuchElementException, NullPointerException{
		WebElement ele = driver.findElement(By.xpath(element));
		return ele;
	}
	
	
	public static void main(String[] args) {
		initDriver init = new initDriver();
		WebDriver driver = init.openBrowser();
		
		
		init.setUrl();
		
		
		WebElement username = elementFound(driver, usernameXpath);
		WebElement password = elementFound(driver, passwordXpath);
		WebElement submit =   elementFound(driver, submitXpath);
		WebElement message = elementFound(driver, messageXpath);
		
		
		
		System.out.println("The username css value is :\t"+username.getCssValue("width"));					// WebElement Method
		System.out.println("The username is displayed :\t"+username.isDisplayed());  						// WebElement Method 		
		System.out.println("The username is enabled :\t"+username.isEnabled());  	 						// WebElement Method
		System.out.println("The username is selected :\t"+username.isSelected());  							// WebElement Method
		System.out.println("The username tag is :\t"+username.getTagName());  	 						// WebElement Method
		System.out.println("The value of name attribute is :\t"+username.getAttribute("name"));  		// WebElement Method
		System.out.println("The value of name dom attribute is :\t"+username.getDomAttribute("name"));	// WebElement Method
		System.out.println("The value of name dom property is :\t"+username.getDomProperty("name"));		// WebElement Method
		System.out.println("The message of text is  :\t"+message.getText());    						// WebElement Method
		
			
		username.sendKeys("ganesh");				// WebElement Method
		username.clear();							// WebElement Method
		password.sendKeys("ganesh");				// WebElement Method
		submit.click();								// WebElement Method
				
		init.quitDriver();
	}
}
