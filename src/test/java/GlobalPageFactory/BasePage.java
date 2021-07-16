package GlobalPageFactory;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.DriverFactory;

public class BasePage extends DriverFactory {
	protected static WebDriver getDriver;
	JavascriptExecutor js = null;
	WebDriverWait wait = null;

	protected BasePage() {
		this.getDriver = getDriver();
		// PageFactory.initElements(getDriver, this);
	}

	public void waitForVisibilityOfWebElement(WebElement webElement, int timeUnits) {
		new WebDriverWait(getDriver, timeUnits).until(ExpectedConditions.visibilityOf(webElement));
	}

	public void jsClickWebElement(WebElement webElement, int timeUnit) {
		waitForVisibilityOfWebElement(webElement, timeUnit);
		js.executeScript("arguments[0].click();", webElement);
	}

	public void clickWebElement(WebElement webElement, int timeUnit) {
		waitForVisibilityOfWebElement(webElement, timeUnit);
		webElement.click();
	}

	public void enterText(WebElement webElement, String inputText, int timeUnit) {
		waitForVisibilityOfWebElement(webElement, timeUnit);
		webElement.clear();
		webElement.sendKeys(inputText);
	}

	public String getText(WebElement webElement, int timeUnit) {
		waitForVisibilityOfWebElement(webElement, timeUnit);
		return webElement.getText();
	}

	public void softValidate(String expected, String actual, String description) {
		Assert.assertEquals(description, expected, actual);
	}

	public void softValidate(Double expected, Double actual, String description) {
		Assert.assertEquals(description, expected, actual);
	}

	public void softValidate(Boolean expected, Boolean actual, String description) {
		Assert.assertEquals(description, expected, actual);
	}

	public void softValidate(Integer expected, Integer actual, String description) {
		Assert.assertEquals(description, expected, actual);
	}

}
