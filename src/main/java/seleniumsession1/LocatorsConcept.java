package seleniumsession1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		// create a webelement + perform action(click, sendkeys, gettext, isDisplayed)
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		// first approach
		// driver.findElement(By.id("input-email")).sendKeys("sneha@123");
		// driver.findElement(By.id("input-password")).sendKeys("test@123");

		// second approach
//		WebElement emailid=driver.findElement(By.id("input-email"));
//		WebElement Password=driver.findElement(By.id("input-password"));
//		emailid.sendKeys("sneha@gmail.com");
//		Password.sendKeys("test@123");

		// third approach
//		By email_id=By.id("input-email");
//		By pass_id=By.id("input-password");
//		WebElement emailid=driver.findElement(email_id);	
//		WebElement Password=driver.findElement(pass_id);
//		emailid.sendKeys("sneha@gmail.com");
//        Password.sendKeys("test@123");

		// fourth approach
//      By email_id=By.id("input-email");
//		By pass_id=By.id("input-password");
//		getElement(email_id).sendKeys("naveen@gmail.com");
//      	getElement(pass_id).sendKeys("naveen@123");
		
		//fifth approach
//		By email_id=By.id("input-email");
//		By pass_id=By.id("input-password");
//		dosendkeys(email_id,"Sneha@123");
//		dosendkeys(pass_id,"test@123");
		
	// Sixth Approach
		By email_id=By.id("input-email");
     	By pass_id=By.id("input-password");
     	ElementUtil eutil=new ElementUtil(driver);
     	eutil.dosendkeys(email_id, "Sneha@123");
     	eutil.dosendkeys(pass_id,"123456");
     	
		
		

	}
	
	public static void dosendkeys(By locator,String value) {
	getElement(locator).sendKeys(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
