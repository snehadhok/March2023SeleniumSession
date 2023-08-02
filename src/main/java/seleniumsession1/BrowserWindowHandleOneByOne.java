package seleniumsession1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandleOneByOne {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();// Browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");// w1
		Thread.sleep(3000);
		WebElement fbEle = driver.findElement(By.xpath("//a[contains(@href,'facebook')]"));
		WebElement twEle = driver.findElement(By.xpath("//a[contains(@href,'twitter')]"));
		WebElement liEle = driver.findElement(By.xpath("//a[contains(@href,'linkedin')]"));
		WebElement ytEle = driver.findElement(By.xpath("//a[contains(@href,'youtube')]"));
		fbEle.click();
		Thread.sleep(1000);
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

		twEle.click();
		Set<String> handles1 = driver.getWindowHandles();
		Iterator<String> it1 = handles1.iterator();
		String parentWindow1 = it1.next();
		System.out.println(parentWindow1);
		String childWindow1 = it1.next();
		System.out.println(childWindow1);
		driver.switchTo().window(childWindow1);
		System.out.println("child window url: " + driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(parentWindow);

		liEle.click();
		Set<String> handles2 = driver.getWindowHandles();
		Iterator<String> it2 = handles2.iterator();
		String parentWindow2 = it2.next();
		System.out.println(parentWindow2);
		String childWindow2 = it2.next();
		System.out.println(childWindow2);
		driver.switchTo().window(childWindow2);
		System.out.println("child window url: " + driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(parentWindow);

		ytEle.click();
		Set<String> handles3 = driver.getWindowHandles();
		Iterator<String> it3 = handles3.iterator();
		String parentWindow3 = it3.next();
		System.out.println(parentWindow3);
		String childWindow3 = it3.next();
		System.out.println(childWindow3);
		driver.switchTo().window(childWindow3);
		System.out.println("child window url: " + driver.getCurrentUrl());
		driver.close();
		
		driver.switchTo().window(parentWindow);
		System.out.println("parent window url: " + driver.getCurrentUrl());

	}

}
