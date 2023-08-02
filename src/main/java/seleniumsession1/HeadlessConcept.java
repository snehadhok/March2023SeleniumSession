package seleniumsession1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessConcept {
	WebDriver driver;
	public static void main(String[] args) {
		ChromeOptions co= new ChromeOptions();
		co.addArguments("--headless");
		
		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("--headless");
		
		EdgeOptions eo = new EdgeOptions();
		eo.addArguments("--headless");

		WebDriver driver = new EdgeDriver(eo);
		driver.get("https://www.amazon.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		
		

	}

}
