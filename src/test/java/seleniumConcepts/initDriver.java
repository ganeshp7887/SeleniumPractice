package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class initDriver {
	
	private static String[] myoptions = {};
	private static String Path = ".\\src\\test\\java\\Drivers\\geckodriver.exe";
	private static WebDriver driver = null;
	private static String url = "https://www.demo.guru99.com/v2/";
	
	public WebDriver initDriver() {
			System.setProperty("webdriver.gecko.driver", Path);
			FirefoxOptions options = new FirefoxOptions();
			for(String option : myoptions) {
				options.addArguments(option);
			}
			this.driver = new FirefoxDriver(options);
			this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return this.driver;

	}
	
	public void setUrl() {
		this.driver.manage().window().maximize();
		this.driver.get(url);
	}
	
	
	public void setUrl(String url) {
		this.driver.manage().window().maximize();
		this.driver.get(url);
	}
	
	public void quitDriver() {
		try {
			Thread.sleep(5000);
			this.driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
