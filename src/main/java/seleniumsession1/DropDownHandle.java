package seleniumsession1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/try-it-free");
		Thread.sleep(4000);
		By country = By.id("Form_getForm_Country");
		//WebElement country_ele = driver.findElement(country);
		//Select select = new Select(country_ele);
		//select.selectByIndex(5);
		//select.selectByValue("India");
		//select.selectByVisibleText("France");
		doSelectDropDownByIndex (country,5);
		doSelectDropDownByvisibletext (country, "India");
		doSelectDropDownByvalue(country,"France");
	
		
	}
	public static WebElement getelement(By locator) {
		return driver.findElement(locator);
	}
	public static void doSelectDropDownByIndex (By locator, int index) {
		Select select = new Select(getelement(locator));
		if(index<0) {
			System.out.println("please pass the right (+ve) index");
			return;
		}
		select.selectByIndex(index);
	}
	public static void doSelectDropDownByvisibletext (By locator, String visibletext) {
		Select select = new Select(getelement(locator));
		if(visibletext==null) {
			System.out.println("please pass the right visible text and it can not be null");
			return;
		}
		select.selectByVisibleText(visibletext);
	}
	public static void doSelectDropDownByvalue (By locator, String value) {
		Select select = new Select(getelement(locator));
		if(value==null) {
			System.out.println("please pass the right visible text and it can not be null");
			return;
		}
		select.selectByValue(value);
		
	}
	

}
