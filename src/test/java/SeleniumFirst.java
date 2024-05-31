import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;

public class SeleniumFirst {
	private static WebElement username = null;
	
	
	public static void main(String[] args) throws IOException {
		String WebdriverPath = "C:\\Users\\ganeshp\\eclipse-workspace\\SeleniumPractice\\src\\test\\java\\Drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", WebdriverPath);
		WebDriver dr = new FirefoxDriver();
		dr.manage().window().setSize(new org.openqa.selenium.Dimension(1000, 700));
		dr.manage().window().setPosition(new Point(200, 0));
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dr.get("https://demo.guru99.com/v2/");
		dr.navigate().back();
		username = dr.findElement(By.cssSelector("input[name='uid']"));
		username.sendKeys("mngr573839");
		WebElement pass = dr.findElement(By.cssSelector("input[type=password]")); //css selector find elements by id, class, attribute, sub-string , inner-string
		pass.sendKeys("uhAnUmy");
		WebElement submit = dr.findElement(By.xpath("//*[@name='btnLogin']"));
		WebElement ss = dr.findElement(By.tagName("input"));
		submit.click();
		String cururl = dr.getCurrentUrl();
		System.out.println(cururl);
		if (cururl.contentEquals("https://demo.guru99.com/v2/")) {
			System.out.println("wah");
		}else {
			System.out.println("waaaaaaah");
		}
		WebElement wb = dr.findElement(By.linkText("here"));
		wb.click();
		if (dr != null) {
		dr.quit();
		}
	}
}