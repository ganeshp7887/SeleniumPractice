package seleniumConcepts;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import junit.framework.Assert;



public class windowHandling {
	
	public void tabWindowHandling() throws InterruptedException {
		String windowss = "";
		initDriver init = new initDriver();
		WebDriver driver = init.initDriver();
		String Url = "https://demoqa.com/browser-windows";
		String childUrlShouldBe = "https://demoqa.com/sample";
		String switchedUrl = "";
		init.setUrl(Url);
		String parentUrlBeforeSwitch = driver.getCurrentUrl();
		driver.findElement(By.xpath("//button[@id='tabButton']")).click();
		String parentWindow = driver.getWindowHandle();
		System.out.println("The parent window is :\t"+parentWindow);
		
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if(!parentWindow.contentEquals(window)) {
				driver.switchTo().window(window);
				System.out.println("The switched window ID is :\t"+window);
				Thread.sleep(2000);
				switchedUrl = driver.getCurrentUrl();
				System.out.println("The switched window url is :\t"+switchedUrl);
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
		WebDriver driver =	init.initDriver();
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
			}
		}
			driver.switchTo().window(parentWindow);
			String parentUrlAfterSwitch = driver.getCurrentUrl();
			System.out.println("The parent window url after switch is :\t"+parentUrlAfterSwitch);
			Assert.assertEquals("Not Matched",parentUrlBeforeSwitch, parentUrlAfterSwitch);
			Assert.assertEquals("Not matched", switchedUrl, childUrlShouldBe);
			init.quitDriver();
		}
	
	public static void main(String[] args) throws InterruptedException {
		windowHandling wh = new windowHandling();
		wh.tabWindowHandling();
		wh.newWindowHandling();
	}
}