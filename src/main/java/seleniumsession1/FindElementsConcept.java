package seleniumsession1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		By links = By.tagName("a");
		List<WebElement> linkslist = driver.findElements(links);
		
		System.out.println(linkslist.size());
		
				
	     int linkscount = linkslist.size();
		for(int i=0;i<linkscount;i++) {
			String text = linkslist.get(i).getText();
			
			
			if(!text.isEmpty()){
			System.out.println(i+" "+text);
			}			
		}

	}
	}



