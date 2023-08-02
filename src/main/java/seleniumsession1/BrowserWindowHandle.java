package seleniumsession1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();// Browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");// w1
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@href,'facebook')]")).click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindow = it.next();
		System.out.println(parentWindow);
		String childWindow = it.next();
		System.out.println(childWindow);
		driver.switchTo().window(childWindow);
		System.out.println("child window url: " + driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println("parent window url: " + driver.getCurrentUrl());
		driver.quit();
		
		

	}

}
