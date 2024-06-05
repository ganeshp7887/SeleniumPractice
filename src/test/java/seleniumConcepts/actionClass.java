package seleniumConcepts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class actionClass {
	
	
	public void keyBoardActions() {
		
				// First, navigate to "https://demoqa.com/text-box."
				// Secondly, enter the Full name: "Mr.Peter Haynes".
				// Thirdly, enter the Email: "PeterHaynes@toolsqa.com."
				// After that, Enter the Current Address: "43 School Lane London EC71 9GO".
				// Fifthly, click on the Current Address text box and Copy the Current Address.
				// After that, paste the copied address in the Permanent Address text box.
				// Finally, validate that the text in the Current Address and Permanent Address is the same.
				
				initDriver init = new initDriver();
				WebDriver driver =  init.initDriver();
				String UrlForDragDropTest = "https://demoqa.com/text-box";
				
				init.setUrl(UrlForDragDropTest);
				
				WebElement userNameField = driver.findElement(By.cssSelector("input#userName"));
				WebElement userEmailField = driver.findElement(By.cssSelector("input#userEmail"));
				WebElement currentAddressField = driver.findElement(By.cssSelector("textArea#currentAddress"));
				WebElement permanentAddressField = driver.findElement(By.cssSelector("#permanentAddress"));
				WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
				CharSequence pressControl = Keys.CONTROL;
				
				userNameField.sendKeys("Mr. Peter Haynes");
				userEmailField.sendKeys("PeterHaynes@toolsqa.com");
				currentAddressField.sendKeys("43 School Lane London EC71 9GO");
				
				
				// Action is a class used to perform mouse and keyboard events on web page.
				
				Actions ac = new Actions(driver);
				ac.keyDown(pressControl).sendKeys("A").keyUp(pressControl).build().perform(); 		// Select all
				ac.keyDown(pressControl).sendKeys("C").keyUp(pressControl).build().perform();		// Copy Text
				ac.sendKeys(Keys.TAB).perform(); 													// Go to next element
				ac.keyDown(pressControl).sendKeys("V").keyDown(pressControl).build().perform(); 	// Paste Text
				submitButton.click();																// click on submit button
				System.out.println("The current address is :\t"+currentAddressField.getAttribute("value")+"\nThe permanent address is :\t"+permanentAddressField.getAttribute("value"));
				Assert.assertEquals("Not matched", currentAddressField.getAttribute("value"), permanentAddressField.getAttribute("value"));
				init.quitDriver();
	}
	
	public void mouseActions() {
		
		initDriver init = new initDriver();
		WebDriver driver =  init.initDriver();
		String UrlForDragDropTest = "https://www.demo.guru99.com/test/drag_drop.html";
		
		init.setUrl(UrlForDragDropTest);
		
		WebElement menuFirstItem = driver.findElement(By.xpath("//div[@id='navbar-brand-centered']/ul/li[1]/a"));
		WebElement menuDraganddrop = driver.findElement(By.xpath("//div[@Id='navbar-brand-centered']/ul/li[1]/ul/li[19]"));
		WebElement dragableSourceElement = driver.findElement(By.xpath("//div[@id='products']/div/ul/li[2]"));
		WebElement dragableSourceElement2 = driver.findElement(By.xpath("//div[@id='products']/div/ul/li[4]"));
		WebElement dragableTargetElement = driver.findElement(By.xpath("//div[@id='shoppingCart4']/div/ol/li"));
		
		// Action is a class used to perform mouse and keyboard events on webpage.
		
		Actions ac = new Actions(driver);
		
		ac.click(dragableSourceElement).perform(); 							 		// performs click action of mouse event
		ac.doubleClick(dragableSourceElement2).perform(); 							// performs double click operation from mouse events.
		ac.moveToElement(dragableSourceElement).perform(); 							// Mouse moves to the element provided ()
		ac.contextClick(dragableSourceElement).perform(); 							// Perform left click from mouse
		ac.dragAndDrop(dragableSourceElement, dragableTargetElement).perform(); 	// drag and drops elements form source to destination
		 
		init.quitDriver();
		
	}
	
	public static void main(String[] args) {
		actionClass ac = new actionClass();
		
		/*  Keyboard Action method
		 		* keyUp
		 		* keyDown
		 		* sendKeys
		*/
		ac.keyBoardActions();
		
		/*  Mouse Action method
 				* Click
 				* doubleClick
 				* contextClick
 				* moveToElement
 				* dragAndDrop
 		*/
		ac.mouseActions();
	}
}
