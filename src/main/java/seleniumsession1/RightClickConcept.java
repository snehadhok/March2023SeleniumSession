package seleniumsession1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		Actions act = new Actions(driver);
		WebElement rightClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));
		act.contextClick(rightClickEle).perform();
		List<WebElement> optionsList = driver.findElements(By.cssSelector("ul.context-menu-list.context-menu-root"));
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals("Edit")) {
				e.click();
				break;
			}

		}

		By contextMenuLocator = By.xpath("//span[text()='right click me']");
		//span[text()='Quit']
		selectRightClickOption(contextMenuLocator, "Quit");
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void selectRightClickOption(By contextMenuLocator, String OptionValue) {
		Actions act = new Actions(driver);
		act.contextClick(getElement(contextMenuLocator)).perform();
	    By optionLocator = By.xpath("//span[text()='"+OptionValue+"']");
	    getElement(optionLocator).click();
	    
		

	}

}
