package com.crm.qa.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.utilitylayer.WaitUtil;

public class BaseClassInitialization {
	public static WebDriver driver;
	public static Properties prop;

	public BaseClassInitialization() throws IOException {
		prop = new Properties();
		FileInputStream fl = new FileInputStream(
				"C:\\Users\\Ashish\\Desktop\\Sneha Sinha\\AutomationFramework\\src\\main\\java\\com\\crm\\qa\\configlayer\\config.properties");
		prop.load(fl);

	}

	public void InitializationMethod() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Ashish\\Downloads\\chromedriver-v0.29.0-win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("ff")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Ashish\\Downloads\\geckodriver-v0.29.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Ashish\\Downloads\\internetexplorerdriver-v0.29.0-win32\\internetexplorerdriver.exe");
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(WaitUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(WaitUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); 
		driver.get(prop.getProperty("url"));
	}

}
