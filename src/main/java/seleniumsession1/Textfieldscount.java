package seleniumsession1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Textfieldscount {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");	
		By textfields = By.tagName("img");
		List<WebElement> totaltextfields = driver.findElements(textfields);
		System.out.println(totaltextfields.size());
		
		
	}

}
