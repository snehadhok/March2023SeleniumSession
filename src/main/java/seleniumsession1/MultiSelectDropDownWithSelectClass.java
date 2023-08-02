package seleniumsession1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropDownWithSelectClass {
	static WebDriver driver;

	public static void main(String[] args) {
	    driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");
		WebElement dropDownEle = driver.findElement(By.xpath("//select[@multiple]"));
		Select select = new Select(dropDownEle);
		if(select.isMultiple()) {
			System.out.println("multi select is possible");
			select.selectByVisibleText("American flamingo");
			select.selectByVisibleText("Chilean flamingo");
			select.selectByVisibleText("Lesser flamingo");
			select.selectByVisibleText("James's flamingo");
		}
		
		select.deselectByVisibleText("Lesser flamingo");
		select.deselectAll();
		
		
	}
	
	public static void multiSelectDropDown(By Locator, String value1,String value2,String value3,String value4) {
		WebElement dropDownEle = driver.findElement(Locator);
		Select select = new Select(dropDownEle);
		if(select.isMultiple()) {
			System.out.println("multi select is possible");
			select.selectByVisibleText("Value1");
			select.selectByVisibleText("Value2");
			select.selectByVisibleText("Value3");
			select.selectByVisibleText("Value4");
		}
		
	}
	
	
	
	
	
	
}
    