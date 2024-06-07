package seleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;


public class frameHandling {
	
	// Frame is an WebDriver method.
	// Frame method can accept index , name or ID, WebElement path as argument.
	// In case of nested frames if we use defaultContent() method it will switch back to main frame/window.
	// In case of frame not found NoSuchFrameException occurs.
	// frame method in selenium.
		/*
			 * 	driver.switchTo().frame(Int Index)					
			 * 	driver.switchTo().frame(String nameorID)			
			 * 	driver.switchTo().frame(WebElement frame)			
			 *	driver.switchTo().defaultContent()				
		*/

	public void singleFrameHandling() {
		initDriver init = new initDriver();
		WebDriver driver = init.openBrowser();
		String Url = "https://demoqa.com/frames";
		init.setUrl(Url);
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='frame1']")); 
			driver.switchTo().frame(frame);			// by WebElement
		//driver.switchTo().frame(1); 				// by Index
		//driver.switchTo().frame("frame1"); 		// by IdOrName
		
		String textInFrame = driver.findElement(By.xpath("//*[@id='sampleHeading']")).getText();
		System.out.println("The text in frame is :\t"+textInFrame);
		driver.switchTo().defaultContent(); // Back to original window
		String textInMainpage = driver.findElement(By.xpath("//div[@id='framesWrapper']/div[1]")).getText();
		System.out.println("The text in main page is :\t"+textInMainpage);
		init.quitDriver();
	
	}

	public void nestedFrameHandling() {
		initDriver init = new initDriver();
		WebDriver driver = init.openBrowser();
		String Url = "https://demoqa.com/nestedframes";
		init.setUrl(Url);
		WebElement parentframe = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(parentframe);			// by WebElement
		String textInFrame = driver.findElement(By.xpath("/html/body")).getText();
		System.out.println("The text in frame is :\t"+textInFrame);
		WebElement childframe = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
		driver.switchTo().frame(childframe);			// by WebElement
		String textInChildFrame = driver.findElement(By.xpath("/html/body/p")).getText();
		System.out.println("The text in child frame is :\t"+textInChildFrame);
		driver.switchTo().defaultContent();
		String textInMainpage = driver.findElement(By.xpath("//div[@id='framesWrapper']/div[1]")).getText();
		System.out.println("The text in main page is :\t"+textInMainpage);
		init.quitDriver();
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		frameHandling fh = new frameHandling();
		//fh.singleFrameHandling();
		//fh.nestedFrameHandling();
	
	}
}