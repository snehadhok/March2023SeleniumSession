package seleniumsession1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import customException.FrameworkException;

public class ElementUtil {
	private WebDriver driver;
	private Actions act;

	ElementUtil(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
	}

//1
	public void dosendkeys(By locator, String value) {
		if (value == null) {
			System.out.println("value can not be null while using sendKeys method");
			throw new FrameworkException("VALUECANNOTBENULL");
		}
		getElement(locator).sendKeys(value);
	}

//2
	public String doElementGetText(By locator) {
		String eleText = getElement(locator).getText();
		System.out.println("Element Text is =====>" + eleText);
		return eleText;
	}

	public WebElement getLinkEleByText(String linkText) {
		return driver.findElement(By.linkText(linkText));
	}

//3
	public boolean checkElementIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

//4
	public String getElementAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

//5
	public boolean checkElementIsDisabled(By locator) {
		String disabledValue = getElement(locator).getAttribute("disabled");
		if (disabledValue.equals("true")) {
			return true;
		}
		return false;
	}

//6
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

//7
	public void doclick(By locator) {
		getElement(locator).click();
	}

//8
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

//9
	public int getElementsCount(By locator) {
		return getElements(locator).size();

	}

//10
	public List<String> listElementTextList(By locator) {
		List<WebElement> elelist = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : elelist) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

//11		
	public String getFooterHeaderTest(String footerText) {

		String footerHeaderText = driver.findElement(By.xpath(
				"//a[text()='" + footerText + "']/ancestor::div[@class='navFooterLinkCol navAccessibility']/div"))
				.getText();
		return footerHeaderText;
	}

//12	
	public void selectEmp(String empName) {
		driver.findElement(
				By.xpath("//a[text()='" + empName + "']/parent::td/preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}

//13
	public List<String> getEmpInfo(String empName) {
		List<WebElement> infoList = driver
				.findElements(By.xpath("//a[text()='" + empName + "']/parent::td/following-sibling::td"));
		System.out.println(infoList.size());
		List<String> infoValList = new ArrayList<String>();
		for (WebElement e : infoList) {
			String text = e.getText();
			infoValList.add(text);
		}
		return infoValList;
	}

//14	
	public void clickOnElement(By locator, String linkText) {
		List<WebElement> linksList = getElements(locator);
		System.out.println("total number of links = " + linksList.size());

		for (WebElement e : linksList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(linkText)) {
				e.click();
				break;
			}
		}
	}

//15
	public void doSearch(By searchLocator, By searchSuggLocator, String searchKey, String suggName)
			throws InterruptedException {
		dosendkeys(searchLocator, searchKey);
		Thread.sleep(4000);
		List<WebElement> suggList = getElements(searchSuggLocator);
		System.out.println(suggList.size());
		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(suggName)) {
				e.click();
				break;
			}
		}
	}

//16
	public String getWcTakerName(String batsmanname) {
		return driver
				.findElement(By.xpath("//span[text()='" + batsmanname + "']/ancestor::td/following-sibling::td/span"))
				.getText();
	}

//17
	public void getScoreCard(String batsmanname) {
		List<WebElement> scorecard = driver.findElements(By.xpath("//span[text()='" + batsmanname
				+ "']/ancestor::td/following-sibling::td[contains(@class,'ds-text-right')]"));
		int scorecardsize = scorecard.size();
		for (int i = 1; i <= scorecardsize; i++) {
			String text = scorecard.get(i).getText();
			System.out.println(text);

		}
	}

	// **************************************DropDownUtil**************************************************
	public WebElement getelement(By locator) {
		return driver.findElement(locator);
	}

	public void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getelement(locator));
		if (index < 0) {
			System.out.println("please pass the right (+ve) index");
			return;
		}
		select.selectByIndex(index);
	}

	public void doSelectDropDownByvisibletext(By locator, String visibletext) {
		Select select = new Select(getelement(locator));
		if (visibletext == null) {
			System.out.println("please pass the right visible text and it can not be null");
			return;
		}
		select.selectByVisibleText(visibletext);
	}

	public void doSelectDropDownByvalue(By locator, String value) {
		Select select = new Select(getelement(locator));
		if (value == null) {
			System.out.println("please pass the right visible text and it can not be null");
			return;
		}
		select.selectByValue(value);

	}

	public int getDropDownOptionsCount(By locator) {
		Select select = new Select(getelement(locator));
		return select.getOptions().size();
	}

	public List<String> getDropDownTextList(By locator) {

		Select select = new Select(getelement(locator));
		List<WebElement> OptionList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();
		for (WebElement e : OptionList) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}

	public void doSelectDropDownValue(By locator, String dropDownValue) {
		Select select = new Select(getelement(locator));
		List<WebElement> OptionList = select.getOptions();

		for (WebElement e : OptionList) {
			String text = e.getText();
			if (text.equals(dropDownValue)) {
				e.click();
				break;
			}
			System.out.println(text);
		}

	}

	public void doSelectDropDownValueUsingLocator(By locator, String dropDownValue) {
		List<WebElement> optionsList = driver.findElements(locator);
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(dropDownValue)) {
				e.click();
				break;
			}
		}
	}

	// ****************Actions utils********************//
	public void doDragAndDrop(By sourcelocator, By targetlocator) {
		act.dragAndDrop(getElement(sourcelocator), getElement(targetlocator)).perform();
		;

	}

	public void selectRightClickOption(By contextMenuLocator, String OptionValue) {
		act.contextClick(getElement(contextMenuLocator)).perform();
		By optionLocator = By.xpath("//span[text()='" + OptionValue + "']");
		getElement(optionLocator).click();
	}

	public void doActionsClick(By locator) {
		act.click(getElement(locator)).perform();
		;
	}

	public void doActionsSendKeys(By locator, String value) {
		act.sendKeys(getElement(locator), value);
	}

	public void MultiLevelMenuHandling(By level1MenuLocator, By level2MenuLocator) throws InterruptedException {
		act.moveToElement(getElement(level1MenuLocator)).build().perform();
		Thread.sleep(2000);
		doclick(level2MenuLocator);

	}

	public void muliLevelMenuHandling(By level1Locator, String level2, String level3, String level4)
			throws InterruptedException {
		act.moveToElement(getElement(level1Locator)).perform();
		Thread.sleep(1500);
		act.moveToElement(getLinkEleByText(level2)).perform();
		Thread.sleep(1500);
		act.moveToElement(getLinkEleByText(level3)).perform();
		Thread.sleep(1500);
		getLinkEleByText(level4).click();
	}

	public void muliLevelMenuHandling(By level1Locator, String level2, String level3) throws InterruptedException {
		act.moveToElement(getElement(level1Locator)).perform();
		Thread.sleep(1500);
		act.moveToElement(getLinkEleByText(level2)).perform();
		Thread.sleep(1500);
		getLinkEleByText(level3).click();
	}

	// **************WaitUtils*************************//
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public String waitForTitleContains(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
				return driver.getTitle();
			} else {
				System.out.println(titleFraction + " title value is not present...");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(titleFraction + " title value is not present...");
			return null;
		}
	}

	public String waitForTitleIs(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.titleIs(titleValue))) {
				return driver.getTitle();
			} else {
				System.out.println(titleValue + " title value is not present...");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(titleValue + " title value is not present...");
			return null;
		}
	}

	public String waitForURLContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
				return driver.getCurrentUrl();
			} else {
				System.out.println(urlFraction + " url value is not present...");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(urlFraction + " url value is not present...");
			return null;
		}
	}

	public String waitForURLToBe(String urlValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.urlToBe(urlValue))) {
				return driver.getCurrentUrl();
			} else {
				System.out.println(urlValue + " url value is not present...");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(urlValue + " url value is not present...");
			return null;
		}
	}

	public Alert waitForJSAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public boolean waitForNumberOfBrowserWindows(int timeOut, int numberOfWindowsToBe) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	}

	public void waitForFrameByLocator(By frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public void waitForFrameByIndex(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public void waitForFrameByFrameNameOrID(String frameNameOrID, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrID));
	}

	public void waitForFrameByFrameElement(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	public void clickElementWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

	}

	// ***********************FluentWait Utils**************//

	public WebElement waitForElementVisibleWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage("----time out is done...element is not found..." + locator);

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public WebElement waitForElementPresenceWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage("----time out is done...element is not found..." + locator);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public Alert waitForJSAlertWithFluentWait(int timeOut, int pollingTime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoAlertPresentException.class)
				.withMessage("----time out is done...Js alert is not found...");
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitForFrameWithFluentWait(String frameNameOrID, int timeOut, int pollingTime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchFrameException.class)
				.withMessage("----time out is done...Frame is not found...with name or id: " + frameNameOrID);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrID));
	}

	public void waitForElementAndEnterValue(By locator, int timeOut, int pollingTime, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.withMessage("----time out is done...element is not found..." + locator)
				.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(value);
	}

	public void waitForElementAndClick(By locator, int timeOut, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.withMessage("----time out is done...element is not found..." + locator)
				.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
	}

	// **************Custom Waits**************//

	public WebElement retryingElement(By locator, int timeOut) {

		WebElement element = null;
		int attempts = 0;

		while (attempts < timeOut) {// 10
			try {
				element = getElement(locator);
				System.out.println("element is found...." + locator + " in attempt " + attempts);
				break;

			} catch (NoSuchElementException e) {
				System.out.println("element is not found...." + locator + " in attempt " + attempts);
				try {
					Thread.sleep(500);// default polling time = 500 ms
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempts++;

		}

		if (element == null) {
			System.out.println("element is not found....tried for " + timeOut + " secs " + " with the interval of "
					+ 500 + " milli secs");
		}

		return element;

	}

	public WebElement retryingElement(By locator, int timeOut, long pollingTime) {

		WebElement element = null;
		int attempts = 0;

		while (attempts < timeOut) {// 10
			try {
				element = getElement(locator);
				System.out.println("element is found...." + locator + " in attempt " + attempts);
				break;

			} catch (NoSuchElementException e) {
				System.out.println("element is not found...." + locator + " in attempt " + attempts);
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempts++;

		}

		if (element == null) {
			System.out.println("element is not found....tried for " + timeOut + " secs " + " with the interval of "
					+ pollingTime + " mill secs");
		}

		return element;

	}
	
	public boolean isPageLoaded(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		String flag = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'")).toString();
		return Boolean.parseBoolean(flag);
	}
	

}
