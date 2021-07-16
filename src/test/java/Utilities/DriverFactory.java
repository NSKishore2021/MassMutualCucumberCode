package Utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	public static WebDriver getDriver;
	public static Properties pos;
	FileInputStream fis;

	public WebDriver getDriver() {
		try {
			pos = new Properties();
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			pos.load(fis);

			String browser = pos.getProperty("browser");
			// String url = pos.getProperty("url");
			String implicit = pos.getProperty("implicit");

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
				getDriver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "");
				getDriver = new FirefoxDriver();
			} else {
				System.setProperty("webdriver.ie.driver", "");
				getDriver = new InternetExplorerDriver();
			}
			// getDriver.get(url);
			getDriver.manage().window().maximize();
			getDriver.manage().timeouts().implicitlyWait(Integer.parseInt(implicit), TimeUnit.SECONDS);
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return getDriver;
	}	
}
