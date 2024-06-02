package seleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class actionClass {
	
	public static void main(String[] args) {
		initDriver init = new initDriver();
		WebDriver driver =  init.initDriver();
		String UrlForDragDropTest = "https://www.demo.guru99.com/test/drag_drop.html";
		
		init.setUrl(UrlForDragDropTest);
		
		WebElement menuFirstItem = driver.findElement(By.xpath("//div[@id='navbar-brand-centered']/ul/li[1]/a"));
		WebElement menuDraganddrop = driver.findElement(By.xpath("//div[@Id='navbar-brand-centered']/ul/li[1]/ul/li[19]"));
		WebElement dragableSourceElement = driver.findElement(By.xpath("//div[@id='products']/div/ul/li[2]"));
		WebElement dragableTargetElement = driver.findElement(By.xpath("//div[@id='shoppingCart4']/div/ol/li"));
		
		// Action is a class used to perform mouse and keyboard events on webpage.
		
		Actions ac = new Actions(driver);
		
		ac.moveToElement(dragableSourceElement).perform();  // Mouse moves to the element provided ()
		// ac.click(menuFirstItem).perform(); // performs click action of mouse event
		ac.contextClick(dragableSourceElement).perform();
		ac.dragAndDrop(dragableSourceElement, dragableTargetElement).perform(); // drag and drops elements form source to destination
		init.quitDriver();
		
		
	}
}
