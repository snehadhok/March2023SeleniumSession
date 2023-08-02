package seleniumsession1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrolling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");

		Actions act = new Actions(driver);
		//scroll page down
//		act.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
		//scroll page up
//		act.sendKeys(Keys.PAGE_UP).perform();
		//completely scroll page down
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		//completely scroll page up
//		Thread.sleep(1000);
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
		//completely scroll down method scrolltoelement
		act.scrollToElement(driver.findElement(By.linkText("Amazon Science")))
		.click(driver.findElement(By.linkText("Amazon Science")))
		.build().perform();
		act.keyDown(Keys.COMMAND).sendKeys(Keys.F5).keyUp(Keys.COMMAND).build().perform();

		
	}

}
