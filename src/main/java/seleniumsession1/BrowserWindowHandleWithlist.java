package seleniumsession1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandleWithlist {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();// Browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");// w1
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@href,'facebook')]")).click();
		Set<String> handles = driver.getWindowHandles();
		List<String> handlesList = new ArrayList<String>(handles);
		String parentWindowId = handlesList.get(0);
		String childWindowId = handlesList.get(1);
		driver.switchTo().window(childWindowId);
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		
		
	}

}
