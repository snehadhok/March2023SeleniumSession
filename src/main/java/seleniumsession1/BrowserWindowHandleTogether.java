package seleniumsession1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandleTogether {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();// Browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");// w1
		Thread.sleep(3000);
		String ParentwindowId=driver.getWindowHandle();
		WebElement fbEle = driver.findElement(By.xpath("//a[contains(@href,'facebook')]"));
		WebElement twEle = driver.findElement(By.xpath("//a[contains(@href,'twitter')]"));
		WebElement liEle = driver.findElement(By.xpath("//a[contains(@href,'linkedin')]"));
		WebElement ytEle = driver.findElement(By.xpath("//a[contains(@href,'youtube')]"));
		fbEle.click();
		twEle.click();
		liEle.click();
		ytEle.click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String WindowId = it.next();
			driver.switchTo().window(WindowId);
			System.out.println(driver.getCurrentUrl());
			if(!WindowId.equals(ParentwindowId)) {
				driver.close();
			}
			driver.switchTo().window(ParentwindowId);
			System.out.println(driver.getCurrentUrl());
			driver.quit();
			
			

		}

	}

}
