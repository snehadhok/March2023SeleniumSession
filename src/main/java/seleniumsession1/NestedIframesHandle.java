package seleniumsession1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIframesHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();//browser - chrome

		//page
		driver.get("https://selectorshub.com/iframe-scenario/");//page
		Thread.sleep(2000);
		driver.switchTo().frame("pact1");
		driver.findElement(By.id("inp_val")).sendKeys("xyz");
		driver.switchTo().frame("pact2");
		driver.findElement(By.id("jex")).sendKeys("xyz");
		driver.switchTo().frame("pact3");
		driver.findElement(By.id("glaf")).sendKeys("xyz");
		
		driver.switchTo().parentFrame();
		driver.findElement(By.id("jex")).sendKeys("new xyz");
		driver.switchTo().parentFrame();
		driver.findElement(By.id("inp_val")).sendKeys("new xyz");
		driver.switchTo().parentFrame();
		String h3Text = driver.findElement(By.tagName("h3")).getText();
		System.out.println(h3Text);
		
		
		
		
		
	}

}
