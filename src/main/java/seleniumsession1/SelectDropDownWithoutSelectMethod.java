package seleniumsession1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownWithoutSelectMethod {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/try-it-free");
		Thread.sleep(4000);
		By country = By.id("Form_getForm_Country");
		//dont use 3 methods: value, index, visibletext
//		Select select = new Select(driver.findElement(country));
//		List<WebElement>OptionList = select.getOptions();
		doSelectDropDownValue(country, "Brazil");
//		for(WebElement e:OptionList) {
//			String text = e.getText();
//			if(text.equals("India")) {
//				e.click();
//				break;
//			}
//			System.out.println(text);
//		}	
	}
	public static WebElement getelement(By locator) {
		return driver.findElement(locator);
	}
	public static void  doSelectDropDownValue(By locator, String dropDownValue) {
		Select select = new Select(getelement(locator));
		List<WebElement>OptionList = select.getOptions();
		
		for(WebElement e:OptionList) {
			String text = e.getText();
			if(text.equals(dropDownValue)) {
				e.click();
				break;
			}
			System.out.println(text);
		}		
		
	}
	


}
