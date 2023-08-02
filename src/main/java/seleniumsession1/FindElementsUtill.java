package seleniumsession1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsUtill {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
//		By links = By.tagName("a");
//		By images = By.tagName("img");

	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	public static int getElementsCount(By locator){
		return getElements(locator).size();
		
	}
	public static List <String> listElementTextList(By locator) {
		List<WebElement> elelist = getElements(locator);
		List <String> eleTextList = new ArrayList<String>(); 
		for(WebElement e : elelist) {
			String text = e.getText();
			if(!text.isEmpty()) {
				eleTextList.add(text);
			}	
		}
		return eleTextList;
		
	}

}
