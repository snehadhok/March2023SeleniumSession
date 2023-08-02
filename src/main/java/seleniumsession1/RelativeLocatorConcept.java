package seleniumsession1;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocatorConcept {

	public static void main(String[] args) {
		//Pending

		//sel 4.x feature:
						//above
		//      left<----ele ---> right
						//below
		//near
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		WebElement ele = driver.findElement(By.linkText("Joe.Root"));
		//right of ele
		List<WebElement>rightIndex= driver.findElements(with(By.xpath("//tr[@class='usr_acn']/td")).toRightOf(ele));
		System.out.println(rightIndex.size());
		for(WebElement e : rightIndex ){
			String text = e.getText();
			System.out.println(text);
			
		}
		//String leftIndex = driver.findElement(with(By.tagName("td")).toLeftOf(ele)).getText();
	}

}
