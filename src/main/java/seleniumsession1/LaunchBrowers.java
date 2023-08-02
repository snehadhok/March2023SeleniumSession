package seleniumsession1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchBrowers {

	public static void main(String[] args) {
		//open the browser - chrome
		//ChromeDriver driver = new ChromeDriver();
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com");
		

				

	}

}
