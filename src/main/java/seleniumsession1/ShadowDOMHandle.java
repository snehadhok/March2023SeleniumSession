package seleniumsession1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
//		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
//		Thread.sleep(5000);
//		String script = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\");";
    	JavascriptExecutor js = (JavascriptExecutor)driver;
//		
//		WebElement Pizza_ele = (WebElement)js.executeScript(script);
//		Pizza_ele.sendKeys("Veg Pizza");
		//********************************************//
		//Google Notification iq ques
		driver.get("chrome://settings/");
		WebElement search = (WebElement) js.executeScript
	("return document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")");
		search.sendKeys("notification");
		
		
		
		
		


	}

}
