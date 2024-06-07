package seleniumConcepts;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import junit.framework.Assert;



public class windowHandling {
	
	// String parentWindow = driver.getWindowHandle() : It is an WebDriver method which returns the parent window ID of current session.
		// return type is string.
	// Set<String> windows = driver.getWindowHandles(): It is an WebDriver method which can store set of window id's present in the current session.
		// return type is set of string.
	// Used for tab switching, new window switching. multiple tabs & window  handling.
	// driver.switchTo().window(windowID) : this command is used for window switching takes an argument as window ID.
	
	
	public void tabWindowHandling() throws InterruptedException {
		initDriver init = new initDriver();
		WebDriver driver = init.openBrowser();
		String Url = "https://demoqa.com/browser-windows";
		String childUrlShouldBe = "https://demoqa.com/sample";
		String switchedUrl = "";
		init.setUrl(Url);
		String parentUrlBeforeSwitch = driver.getCurrentUrl();
		driver.findElement(By.xpath("//button[@id='tabButton']")).click();
		String parentWindow = driver.getWindowHandle();			// returns the parent window ID of current session.
		System.out.println("The parent window is :\t"+parentWindow);
		
		Set<String> windows = driver.getWindowHandles();   // Can store set of window id's present in the current session.
		
		for (String window : windows) {
			if(!parentWindow.contentEquals(window)) {
				driver.switchTo().window(window);
				System.out.println("The switched window ID is :\t"+window);
				Thread.sleep(2000);
				switchedUrl = driver.getCurrentUrl();
				System.out.println("The switched window url is :\t"+switchedUrl);
				String textOnpage = driver.findElement(By.xpath("//*[@id='sampleHeading']")).getText();
				System.out.println("The Text on page is :\t"+textOnpage);
			}
		}
		
		driver.switchTo().window(parentWindow);
		String parentUrlAfterSwitch = driver.getCurrentUrl();
		System.out.println("The parent window url is :\t"+driver.getCurrentUrl());
		Assert.assertEquals("Not Matched",parentUrlBeforeSwitch, parentUrlAfterSwitch);
		Assert.assertEquals("Not matched", switchedUrl, childUrlShouldBe);
		init.quitDriver();
	}
	
	public void newWindowHandling() throws InterruptedException{
		initDriver init = new initDriver();
		WebDriver driver =	init.openBrowser();
		String Url = "https://demoqa.com/browser-windows";
		String childUrlShouldBe = "https://demoqa.com/sample";
		String switchedUrl = "";
		init.setUrl(Url);
		driver.findElement(By.xpath("//button[@id='windowButton']")).click();
		String parentUrlBeforeSwitch = driver.getCurrentUrl();
		String parentWindow = driver.getWindowHandle();
		System.out.println("The parent window ID is :\t"+parentWindow);
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if(!parentWindow.contentEquals(window)) {
				System.out.println("The windows available are :\t"+window);
				driver.switchTo().window(window);
				System.out.println("The switched window ID is :\t"+window);
				Thread.sleep(3000);
				switchedUrl = driver.getCurrentUrl();
				System.out.println("The switched window url is :\t"+switchedUrl);
				String textOnpage = driver.findElement(By.xpath("//*[@id='sampleHeading']")).getText();
				System.out.println("The Text on page is :\t"+textOnpage);
			}
		}
			driver.switchTo().window(parentWindow);
			String parentUrlAfterSwitch = driver.getCurrentUrl();
			System.out.println("The parent window url after switch is :\t"+parentUrlAfterSwitch);
			Assert.assertEquals("Not Matched",parentUrlBeforeSwitch, parentUrlAfterSwitch);
			Assert.assertEquals("Not matched", switchedUrl, childUrlShouldBe);
			init.quitDriver();
		}
	
	public void createNewWindow() throws InterruptedException {
		initDriver init = new initDriver();
		WebDriver driver = init.openBrowser();
		String Url = "https://demoqa.com/nestedframes";
		init.setUrl();
		System.out.println("Original url title is :\t"+driver.getTitle());
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to(Url);
		System.out.println("Tab url title is :\t"+driver.getTitle());
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to(Url);
		System.out.println("New window url title is :\t"+driver.getTitle());
		init.quitDriver();		
	}
	
	public static void main(String[] args) throws InterruptedException {
		windowHandling wh = new windowHandling();
		wh.tabWindowHandling();
		wh.newWindowHandling();
		wh.createNewWindow();
	}
}