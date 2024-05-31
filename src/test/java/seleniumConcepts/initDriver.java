package seleniumConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class initDriver {
	
	private static String[] myoptions = {};
	private static String Path = "C:\\Users\\ganeshp\\eclipse-workspace\\SeleniumPractice\\src\\test\\java\\Drivers\\geckodriver.exe";
	private static WebDriver driver = null;
	private static String url = "https://parabank.parasoft.com/parabank/index.htm";
	
	public WebDriver initDriver() {
			System.setProperty("webdriver.gecko.driver", Path);
			FirefoxOptions options = new FirefoxOptions();
			for(String option : myoptions) {
				options.addArguments(option);
			}
			this.driver = new FirefoxDriver(options);		
			return this.driver;

	}
	
	public void setUrl() {
		this.driver.get(url);
	}
	
	public void setUrl(String url) {
		this.driver.get(url);
	}
}
