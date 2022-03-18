package com.bridgelabz.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.bridgelabz.utility.UtilityClass;
import com.bridgelabz.utility.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties properties;
	public static EventFiringWebDriver eventFiringWebdriver;
	public static WebEventListener eventListener;

	public BaseClass() {
		properties = new Properties();
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(
					"C:\\Users\\ADMIN\\eclipse-workspace\\Java-Programs\\FaceBookPageObjectModel\\src\\main\\java\\com\\bridgelabz\\configuration\\config.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		String browserName = properties.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ADMIN\\Downloads\\chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		// Capture screenshot when test failed
		eventFiringWebdriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eventFiringWebdriver.register(eventListener);
		driver = eventFiringWebdriver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(UtilityClass.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilityClass.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));

	}

}
