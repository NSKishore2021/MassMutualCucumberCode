package PageFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GlobalPageFactory.BasePage;

public class HomePage extends BasePage {

	public HomePage() {
		super();
	}

	DecimalFormat df = new DecimalFormat("#.##");

	@FindBy(id = "xxxxx")
	private WebElement lblMessage;

	public double formatDollaValue(String inDollarValue) {
		String actualAmount = inDollarValue.replace(",", "");
		String plainAmount = actualAmount.replace("$", "");
		BigDecimal sPrice = new BigDecimal(plainAmount);
		return Double.parseDouble(df.format(Double.parseDouble(String.valueOf(sPrice))));
	}

}
