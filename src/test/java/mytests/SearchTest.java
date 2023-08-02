package mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
//	WebDriver driver;
//	@BeforeTest
//	public void setup() {
//		driver = new ChromeDriver();
//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//	}
	@DataProvider
	public Object[][]SearchTestData(){
		return new Object[][] {
			{"macbook",3},
			{"imac",1},
			{"samsung",2},
			{"canon",1},
			{"naveen",0}
		};		
	}
	@Test(dataProvider = "SearchTestData")
	public void searchTest(String searchKey, int expSearchCount) {
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys(searchKey);
		driver.findElement(By.xpath("//div[@id='search']//button")).click();
		
		String header = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		System.out.println(header);
		Assert.assertTrue(header.contains(searchKey));
		
		int actSearchCount=driver.findElements(By.xpath("//div[contains(@class,'product-layout')]")).size();
		System.out.println(searchKey + " count ===>" + actSearchCount);
		Assert.assertEquals(actSearchCount,expSearchCount);
		
	}

}
