package seleniumsession1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateGoogle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		By search = By.name("q");
		//driver.findElement(By.name("q")).sendKeys("naveen automation labs");
		//Thread.sleep(4000);
		By suggestionList = By.xpath("//ul[@role='listbox']//div[@class ='wM6W7d' and @role='presentation']/span");
		doSearch(search,suggestionList,"naveen automation labs","youtube");
		
			
			
		}
	public static void doSearch (By searchLocator, By searchSuggLocator, String searchKey,String suggName) throws InterruptedException {
		driver.findElement(searchLocator).sendKeys(searchKey);
		Thread.sleep(4000);
		List<WebElement>sugglist =
				driver.findElements(searchSuggLocator);
		System.out.println(sugglist.size());
		for(WebElement e: sugglist) {
			String text  = e.getText();
			System.out.println(text);
			if(text.contains(suggName)) {
			e.click();
			break;
			}
			
		}
		
		
		
	}

}
