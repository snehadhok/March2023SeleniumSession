package mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest{
	
	@Test(priority = 1)
	public void googleTitleTest() {
		//driver.get("https://www.google.com");
		Assert.assertEquals(driver.getTitle(), "Google");	
	}
	
	@Test(priority = 2)
	public void googleUrlTest() {
		Assert.assertTrue(driver.getCurrentUrl().contains("google") );
	}
	@Test(priority = 3)
	public void googleSearchTest() {
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).submit();	
		Assert.assertTrue(driver.getTitle().contains("Selenium") );
	    
	}
	

}
