package seleniumsession1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationClass {

	public static void main(String[] args) {
		BrowserUtil brutil = new BrowserUtil();
		WebDriver driver = brutil.launchBrowser("chrome");
		brutil.enterurl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		By email_id = By.id("input-email");
		By pass_id = By.id("input-password");
		By firstname = By.id("input-firstname");
		By lastname = By.id("input-lastname");
		// By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmpassword = By.id("input-confirm");
		ElementUtil eutil = new ElementUtil(driver);
		eutil.dosendkeys(email_id, "Sneha@123");
		eutil.dosendkeys(pass_id, "123456");
		eutil.dosendkeys(firstname, "Sneha");
		eutil.dosendkeys(lastname, "Dhok");
		// eutil.dosendkeys(email, "Sneha@gmail.com");
		eutil.dosendkeys(telephone, "7755979845");
		eutil.dosendkeys(password, "test@123");
		eutil.dosendkeys(confirmpassword, "test@123");
		//brutil.quitbrowser();

	}

}
