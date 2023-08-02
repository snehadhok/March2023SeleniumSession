package seleniumsession1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		//Actions act = new Actions(driver);
	  // WebElement sourceEle = driver.findElement(By.id("draggable"));
	   //WebElement targetEle = driver.findElement(By.id("droppable"));
	   By sourceele = By.id("draggable");
	   By targetele = By.id("droppable");
		//act.clickAndHold(sourceEle).moveToElement(targetEle).release().click().perform();
		//act.dragAndDrop(sourceEle, targetEle).perform();	
		doDragAndDrop(sourceele,targetele);
		
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doDragAndDrop(By sourcelocator,By targetlocator) {
		Actions act = new Actions(driver);
		act.dragAndDrop(getElement(sourcelocator),getElement(targetlocator)).perform();;
		
	}
}
