package seleniumsession1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUpHandle {

	public static void main(String[] args) throws InterruptedException {

		// Alert - JS PopUp /Modal Dialog
		// 1. alert 2.prompt 3.confirm

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		Thread.sleep(2000);
		//1.Js Alert
//		Alert alert= driver.switchTo().alert();
//		String text = alert.getText();
//		System.out.println(text);
//		alert.accept();
		//2 Confirm alert
//		Alert alert= driver.switchTo().alert();
//		String text = alert.getText();
//		System.out.println(text);
//		alert.accept();
		
		//3.propmt alert
		Alert alert= driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		Thread.sleep(2000);
		alert.accept();
		alert.sendKeys("SnehaTest");
		alert.accept();
		String mesg = driver.findElement(By.id("result")).getText();
		System.out.println(mesg);

//		String actText = mesg.split(":")[1].trim();
//		System.out.println(actText);
		
	}

}
