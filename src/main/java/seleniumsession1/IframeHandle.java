package seleniumsession1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();//browser - chrome
		//page
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");//page
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@title='Vehicle-Registration-Forms-and-Examples']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]")));
		
		driver.findElement(By.id("RESULT_TextField-1")).sendKeys("Naveen");
		driver.findElement(By.xpath("//input[@id='RESULT_TextField-3']")).sendKeys("Nashik");
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextArea-5\"]")).sendKeys("This page is used for automation");
		driver.findElement(By.xpath("//input[@class='file_upload']")).sendKeys("C:\\Users\\Admin\\Pictures\\Screenshots");
		driver.findElement(By.xpath("//input[@id='RESULT_TextField-8']")).sendKeys("sneha");
		driver.findElement(By.xpath("//input[@id='RESULT_TextField-9']")).sendKeys("Dhok");
		driver.findElement(By.xpath("//input[@id=\"RESULT_TextField-10\"]")).sendKeys("kamathwade");
		ElementUtil util =new ElementUtil(driver);
		By State =By.xpath("//select[@id=\"RESULT_RadioButton-13\"]");
		util.doSelectDropDownByvisibletext(State, "California");
		driver.switchTo().defaultContent();

	}

}
