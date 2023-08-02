package seleniumsession1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CrincInfo {
	static WebDriver driver;

	public static void main(String[] args) {
 driver = new ChromeDriver();
 driver.
		get("https://www.espncricinfo.com/series/icc-cricket-world-cup-qualifier-2023-1377745/nepal-vs-united-states-of-america-6th-match-group-a-1377751/full-scorecard");
//span[text()='Steven Taylor']/ancestor::td/following-sibling::td/span
//	String WkTakerName = driver.
//	findElement(By.xpath("//span[text()='Steven Taylor']/ancestor::td/following-sibling::td/span")).
//	getText();
//	System.out.println(WkTakerName);
	//span[text()='Sushant Modani']/ancestor::td/following-sibling::td[contains(@class,'ds-text-right')]
List<WebElement>scorecard = driver.findElements
(By.xpath("//span[text()='Sushant Modani']/ancestor::td/following-sibling::td[contains(@class,'ds-text-right')]"));
int scorecardsize = scorecard.size();

for(int i=1;i<=scorecardsize;i++) {
	String text = scorecard.get(i).getText();
	System.out.println(text);
	
}
	}
	
	public static String getWcTakerName ( String batsmanname) {
		return driver.
				 findElement(By.xpath("//span[text()='"+batsmanname+"']/ancestor::td/following-sibling::td/span")).
				getText();	
	}
	public static void getScoreCard(String batsmanname) {
	List<WebElement>scorecard = driver.findElements
			(By.xpath("//span[text()='"+batsmanname+"']/ancestor::td/following-sibling::td[contains(@class,'ds-text-right')]"));
			int scorecardsize = scorecard.size();
			for(int i=1;i<=scorecardsize;i++) {
				String text = scorecard.get(i).getText();
				System.out.println(text);
	
			}
	}
}

