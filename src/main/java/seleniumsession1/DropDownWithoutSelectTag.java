package seleniumsession1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownWithoutSelectTag {

public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Select Option')]")).click();
		
		
		List<WebElement> optionsList =  driver.findElements(By.xpath("//div[contains(@id,'react-select-2-option')]"));
		System.out.println(optionsList.size());
		for(WebElement e: optionsList) {
			String text = e.getText();
			System.out.println(text);
			if(text.contains("Group 1, option 2")) {
				e.click();
				break;
				
			}
		}
		
		driver.findElement(By.xpath("//div[contains(text(),'Select Title')]")).click();
		List<WebElement> optionsList2 =driver.findElements(By.xpath("//div[contains(@id,'react-select-3-option')]"));
		System.out.println(optionsList2.size());
		for(WebElement e: optionsList2) {
			String text = e.getText();
			System.out.println(text);
			if(text.contains("Mrs.")) {
				e.click();
				break;
				
			}
		}
		
	}


}
