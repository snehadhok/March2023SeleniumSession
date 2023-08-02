package mytests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest  {
	
	@Test(priority = 1)
	public void TitleTest() {
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Assert.assertEquals(driver.getTitle(), "Account Login");	
	}
	@Test(priority = 2)
	public void UrlTest() {
		Assert.assertTrue(driver.getCurrentUrl().contains("account/login") );
	}
	
	
	
	 

}
