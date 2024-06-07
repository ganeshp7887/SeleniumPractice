package seleniumConcepts;

import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;

public class cookiesHandling {
	
	// Cookies are small files of information that a web server generates and sends to a web browser
	// To handle cookies in web page manage method is used.
	// Cookies method in selenium.
	/*
		 * 	driver.manage().getCookies()						Returns the set of cookies available in web page.
		 * 	driver.manage().getCookieNamed(String name)			Returns the cookie information of single cookie.
		 * 	driver.manage().addCookie(Cookie name)				Add cookie to the web page.
		 *	driver.manage().deleteCookie(Cookie name)			Delete cookie information from page
		 * 	driver.manage().deleteCookieNamed(String name)		Delete cookie information from page of provided name
		 *	driver.manage().deleteAllCookies()					Delete all available cookies from web page.
		 
	*/
	
	public void getCookiesFromWebpage() {
		initDriver init = new initDriver();
		WebDriver driver = init.openBrowser();
		String Url = "https://demoqa.com/text-box";
		Options manage = driver.manage();
		init.setUrl(Url);
		Set<Cookie> cookies = manage.getCookies();
		for (Cookie cookie : cookies) {
			System.out.println("The cookies in the webpage : \t"+cookie.getName()+"\tThe value is :\t"+cookie.getValue());
		}
		init.quitDriver();
	}
	
	public void getCookieName() {
		initDriver init = new initDriver();
		WebDriver driver = init.openBrowser();
		String Url = "https://demoqa.com/text-box";
		Options manage = driver.manage();
		init.setUrl(Url);
		Cookie cookieName = manage.getCookieNamed("_ga");
		String name = cookieName.getName();
		String value = cookieName.getValue();
		String domain = cookieName.getDomain();
		String expiry = cookieName.getExpiry().toString();
		String path = cookieName.getPath();
		System.out.println("Name \t Value \t Domain \t Expiry \t path");
		System.out.println(name +"\t"+value +"\t"+domain +"\t"+expiry+"\t"+path+"\t");
		init.quitDriver();
	}
	
	public void deleteCookie() {
		initDriver init = new initDriver();
		WebDriver driver = init.openBrowser();
		String Url = "https://demoqa.com/text-box";
		Options manage = driver.manage();
		init.setUrl(Url);
		Cookie cookieNameGA = manage.getCookieNamed("_ga");
		Cookie cookieNameGID = manage.getCookieNamed("_gid");
		System.out.println("The cookie before deleting :\t"+cookieNameGA.toString());
		System.out.println(cookieNameGID.toString());
		manage.deleteCookie(cookieNameGA);    // Delete By Cookie
		manage.deleteCookieNamed("_gid");	  // Delete by String
		manage.deleteAllCookies();			  // Delete All Available cookies
		manage.addCookie(cookieNameGA);
		
		Object[] a = manage.getCookies().toArray();
		for (Object object : a) {
			System.out.print(object.toString()+"\t");
		}
		init.quitDriver();
	}
	
	
	public static void main(String[] args) {
		cookiesHandling ch = new cookiesHandling();
		//ch.getCookiesFromWebpage();
		//ch.getCookieName();
		ch.deleteCookie();
	}
}
