package seleniumConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class selectBoxHandling {
	
	// Select is an class which is used to select values from dropdown.
	// Select class takes an argument as WebElement.  Select select = new Select(WebElement);
	
	/* Select class method 
	 
	 * select.isMultiple()	 							To check if dropdown has multiple selection options.
	 
	 // selection and deselection options
	  
	 *  select.selectByIndex(0);						select by index of option tag.
	 *  select.selectByValue(valueAttribute)			select by value attribute.
	 *  select.selectByVisibleText(String Text);		select by text value.
	 *  select.deselectAll();							Deselect all selected options.
	 *  select.deselectByIndex(0);
	 *  select.deselectByValue(valueAttribute);
	 *  select.deselectByVisibleText(String Text);
	 
	 // get values options
	   
	  *	select.getOptions() 							get all available options from select box
	  * select.getAllSelectedOptions()  				list of selected options
	  * select.getFirstSelectedOption()					First selected options
	  
	 * */
	
	
	private String Url = "https://demoqa.com/select-menu";
	
	public void simpleSelectBox() {
		initDriver init = new initDriver();
		WebDriver driver = init.openBrowser();
		init.setUrl(Url);
		WebElement select = driver.findElement(By.xpath("//select[@id='oldSelectMenu']")); 
		Select sc = new Select(select);
		System.out.println("To check if select box is multiple selection :\t"+sc.isMultiple());
		sc.selectByValue("2");
		System.out.println("The selected option value is : \t"+sc.getFirstSelectedOption().getText());
		init.quitDriver();
	}
	
	public void multipleSelectBox() {
		initDriver init = new initDriver();
		WebDriver driver = init.openBrowser();
		init.setUrl(Url);
		WebElement select = driver.findElement(By.xpath("//select[@id='cars']"));
		Select sc = new Select(select);
		System.out.println("To check if select box is multiple selection :\t"+sc.isMultiple());
		if(sc.isMultiple()) {
			sc.selectByVisibleText("Saab");
			sc.selectByVisibleText("Audi");
		}
		List<WebElement> l = sc.getAllSelectedOptions();
		for (WebElement webElement : l) {
			System.out.println(webElement.getText());
		}
		
		sc.deselectAll();
		init.quitDriver();
	}
	
	public static void main(String[] args) {
		selectBoxHandling sc = new selectBoxHandling();
		sc.simpleSelectBox();
	//	sc.multipleSelectBox();
	}

}
