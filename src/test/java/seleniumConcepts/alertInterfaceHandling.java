package seleniumConcepts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

import java.time.Duration;

import org.junit.Assert;


public class alertInterfaceHandling {
	
	// Alert is an interface use to handle alerts in webPage.
	// Types of alert are simple alert, confirm box, prompt box.
	// There are 4 methods accept, dismiss, getText, sendKeys.
	// if alert not present in web page then noAlertPresentExeption occurs.
	// if page takes time to load then exception could occur it should be handle by explicitly wait conditions.  
	// driver.switchTo().alert() : command is used to handle alert.
	
	private String Url = "https://demoqa.com/alerts";
	
	public void simpleAlert() {
		initDriver init = new initDriver();
		WebDriver driver = init.initDriver();
		String alertTextExpected = "You clicked a button";
		init.setUrl(Url);
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		Alert al = driver.switchTo().alert();
		String altext = al.getText();
		al.accept();
		System.out.println("The lert prompts for :\t"+altext);
		Assert.assertEquals("Not matched", alertTextExpected, altext);
		init.quitDriver();
	}
	
	public void simpleAlertWait() {
		initDriver init = new initDriver();
		WebDriver driver = init.initDriver();
		String alertTextExpected = "This alert appeared after 5 seconds";
		init.setUrl(Url);
		driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert al = wait.until(ExpectedConditions.alertIsPresent());
		String altext = al.getText();
		al.accept();
		System.out.println("The lert prompts for :\t"+altext);
		Assert.assertEquals("Not matched", alertTextExpected, altext);
		init.quitDriver();
	}
	
	public void confirmAlertBox() {
		initDriver init = new initDriver();
		WebDriver driver = init.initDriver();
		String alertTextExpected = "Do you confirm action?";
		init.setUrl(Url);
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		Alert al = driver.switchTo().alert();
		String altext = al.getText();
		al.accept(); 
		String getValue = driver.findElement(By.xpath("//span[@id='confirmResult']")).getText();
		System.out.println(getValue);
		init.quitDriver();
	}
	
	public void promptAlertBox() {
		initDriver init= new initDriver();
		WebDriver driver = init.initDriver();
		init.setUrl(Url);
		driver.findElement(By.xpath("//button[@id='promtButton']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert al = wait.until(ExpectedConditions.alertIsPresent());
		al.sendKeys("ganesh");
		al.accept();
		String spanText = driver.findElement(By.xpath("//span[@id='promptResult']")).getText();
		System.out.println(spanText);
		init.quitDriver();
	}
	
	public static void main(String[] args) {
		alertInterfaceHandling i = new alertInterfaceHandling();
		i.simpleAlert();
		i.simpleAlertWait();
		i.confirmAlertBox();
		i.promptAlertBox();
	}
}
