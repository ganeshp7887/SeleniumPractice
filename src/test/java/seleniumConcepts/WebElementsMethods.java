package seleniumConcepts;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementsMethods {
	
	static private String usernameXpath = "//input[@class='input' and @name='username']";	// Find Elements by Xpath
	static private String passwordXpath = "//input[@class='input' and @name='password']";	// Find Elements by Xpath	
	static private String submitXpath = "//input[@class='button' and @type='submit']";		// Find Elements by Xpath
	static private String forgetXpath = "//*[contains(text(),'Forgot')]";					// Find Elements by Xpath
	static private String labels =  "//ul[@class='leftmenu']/li";							// Find Elements by Xpath
	
	public static WebElement elementFound(WebDriver driver , String element) throws NoSuchElementException{
		WebElement ele = driver.findElement(By.xpath(element));
		return ele;
	}
	
	
	public static void main(String[] args) {
		initDriver init = new initDriver();
		WebDriver driver = init.initDriver();
		
		
		init.setUrl();
		
		
		WebElement username = elementFound(driver, usernameXpath);
		WebElement password = elementFound(driver, passwordXpath);
		WebElement submit =   elementFound(driver, submitXpath);
		WebElement forgot =	  elementFound(driver, forgetXpath);
		
		
		System.out.println("The username css value is :\t"+username.getCssValue("width"));					// WebElement Method
		System.out.println("The username is displayed :\t"+username.isDisplayed());  						// WebElement Method 		
		System.out.println("The username is enabled :\t"+username.isEnabled());  	 						// WebElement Method
		System.out.println("The username is selected :\t"+username.isSelected());  							// WebElement Method
		System.out.println("The username is tag is :\t"+username.getTagName());  	 						// WebElement Method
		System.out.println("The value of name attribute is :\t"+username.getAttribute("name"));  		// WebElement Method
		System.out.println("The value of name dom attribute is :\t"+username.getDomAttribute("name"));	// WebElement Method
		System.out.println("The value of name dom property is :\t"+username.getDomProperty("name"));		// WebElement Method
		System.out.println("The forgot password text is  :\t"+forgot.getText());    						// WebElement Method
		
			
		username.sendKeys("ganesh");				// WebElement Method
		username.clear();							// WebElement Method
		password.sendKeys("ganesh");				// WebElement Method
		submit.click();								// WebElement Method
				
		if(driver != null) {
			driver.quit();							// WebDriver Method
		}
	}
}
