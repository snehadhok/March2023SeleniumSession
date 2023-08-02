package seleniumsession1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		By langlinks = By.xpath("//div[@id='SIvCob']/a");
		clickonElement( langlinks,"मराठी");

	}
	public static void clickonElement(By locator,String linktext) {

	List<WebElement>langlinks = driver.findElements(locator);
	System.out.println("total number of lang link=" +langlinks.size());
	for(WebElement e:langlinks) {
		String text = e.getText();
		System.out.println(text);
		if(text.equals("linktest")) {
			e.click();
			break;		
		}
	}
	
	}
	
	
	
	public WebElement getLinkEleByText(String linkText) {
		return driver.findElement(By.linkText(linkText));
	}
}


