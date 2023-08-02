package seleniumsession1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownWithOptions {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/try-it-free");
		Thread.sleep(4000);
		By country = By.id("Form_getForm_Country");
//		Select select = new Select(driver.findElement(country));
//		List<WebElement>CountryOptionList = select.getOptions();
//		System.out.println(CountryOptionList.size());	
//		for (WebElement e:CountryOptionList) {
//			String text = e.getText();
//			System.out.println(text);				
//		}
		
		
		if(getDropDownTextList(country).contains("India")) {
			System.out.println("pass");
		}
		
		List<String> expCountryOptionsList =  Arrays.asList("India", "Brazil", "Aruba");
		if(getDropDownTextList(country).containsAll(expCountryOptionsList)) {
			System.out.println(expCountryOptionsList + " is available");
		}
	}
	public static WebElement getelement(By locator) {
		return driver.findElement(locator);
	}
	public static int getDropDownOptionsCount(By locator) {
		Select select = new Select(getelement(locator));
		return select.getOptions().size();		
	}
	
	public static List<String> getDropDownTextList(By locator) {
		
		Select select = new Select(getelement(locator));
		List<WebElement>OptionList = select.getOptions();
		int count =0;
		List<String> optionsTextList = new ArrayList<String>();
		for (WebElement e: OptionList) {
			String text = e.getText();
			optionsTextList.add(text);	
			System.out.println(count+""+ text);
			count++;
		}
		return optionsTextList;
		
		
		
		
	}

}
