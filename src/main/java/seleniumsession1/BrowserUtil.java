package seleniumsession1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import customException.FrameworkException;
import java.net.URL;
public class BrowserUtil {
	private WebDriver driver;
	
	public WebDriver launchBrowser(String browsername) {
		System.out.println("browser name is:"+ browsername);
		if(browsername == null) {
			System.out.println("browser cannot be null");
			throw new FrameworkException("BROWSERCANBENOTNULL");
		}
		switch (browsername.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
				default:
					System.out.println("plz pass the right browser name..." + browsername);
					throw new FrameworkException("NOTVALIDBROWSER");
		}
		return driver;
	}
	public void enterurl(String url) {
		if(url.contains("http")) {
		driver.get(url);
		}
		else {
			System.out.println("url should have http(s)");
			throw new FrameworkException("url should have http(s)");
		}
	}
	public void enterurl(URL url){
	if(String.valueOf(url).contains("https")) {
		driver.navigate().to(url);
	}
	else {
		throw new FrameworkException("url should have http(s)");	
		}
	}
	
	public String getpagetitle(){
		 return driver.getTitle();
	}
	
	public String getpageurl() {
	 return driver.getCurrentUrl();
	
	}
	public void quitbrowser() {
		driver.quit();
	}
	public void closebrowser() {
		driver.close();
	
	}
}
