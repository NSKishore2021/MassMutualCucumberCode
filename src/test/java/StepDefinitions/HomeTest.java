package StepDefinitions;

import java.io.IOException;
import PageFactory.HomePage;
import Utilities.DriverFactory;
import Utilities.ReadExcel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeTest extends DriverFactory {
	HomePage homePage;
	Double v1, v2, expectedValue;
	Double actualValue = 0.00;
	ReadExcel readExcel;

	@Given("user provided with valid url")
	public void user_provided_with_valid_url() {
		homePage = new HomePage();
		getDriver.get(pos.getProperty("url"));
	}

	@When("user provides required label value1")
	public void user_provides_required_label_value1() throws IOException {
		{
			double value1 = homePage.formatDollaValue(ReadExcel.getCellValue(1, 0));
			System.out.println(value1);
			actualValue = actualValue + value1;
		}
	}

	@And("user provides required label value2")
	public void user_provides_required_label_value2() throws IOException {
		{
			double value2 = homePage.formatDollaValue(ReadExcel.getCellValue(1, 1));
			System.out.println(value2);
			actualValue = actualValue + value2;
		}
	}

	@And("user provides required label value3")
	public void user_provides_required_label_value3() throws IOException {
		{
			double value3 = homePage.formatDollaValue(ReadExcel.getCellValue(1, 2));
			System.out.println(value3);
			actualValue = actualValue + value3;
		}
	}

	@And("user provides required label value4")
	public void user_provides_required_label_value4() throws IOException {
		{
			double value4 = homePage.formatDollaValue(ReadExcel.getCellValue(1, 3));
			System.out.println(value4);
			actualValue = actualValue + value4;
		}
	}

	@And("user provides required label value5")
	public void user_provides_required_label_value5() throws IOException {
		{
			double value5 = homePage.formatDollaValue(ReadExcel.getCellValue(1, 4));
			System.out.println(value5);
			actualValue = actualValue + value5;
		}
	}

	@Then("verify total count of the values with the expected value")
	public void verify_total_count_of_the_values_with_the_expected_value() throws IOException {
		{

			double expectedValue = homePage.formatDollaValue(ReadExcel.getCellValue(1, 5));
			actualValue = homePage.formatDollaValue(String.valueOf(actualValue));
			System.out.println(expectedValue);
			homePage.softValidate(expectedValue, actualValue, "Total Sum of All the Values are");
			getDriver.close();
		}
	}

}
