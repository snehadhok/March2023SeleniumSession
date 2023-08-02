package seleniumsession1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebtableExample {
static WebDriver driver;
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get("https://www.dezlearn.com/webtable-example/");
 //driver
 //.findElement(By.xpath("//td[contains(text(),'Tim Watson')]/parent::tr/td//input[@type='checkbox']")).click();
		
	driver
	.findElement(By.xpath("(//td[contains(text(),'Tim Watson')]/parent::tr/td)[4]/input")).click();
		//td[contains(text(),'Tim Watson')]/parent::tr/td//input[@type='checkbox']
	}

}
