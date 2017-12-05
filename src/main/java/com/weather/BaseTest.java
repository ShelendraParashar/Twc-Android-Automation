package com.weather;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseTest {

	static FileReader reader;
	static Properties prop;
	static DesiredCapabilities caps;
	static AndroidDriver<AndroidElement> driver;
	static WebDriverWait wait;

	public static void loadConfig() {

		try {
			reader = new FileReader("D:\\Twc-Android-Automation\\AndroidApp-master\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(reader);
			// prop.getProperty("capability.app");

		} catch (IOException e) {
			// TODO Aut o-generated catch block
			e.printStackTrace();
		}

	}

	public static String getCapability(String capName) {
		return prop.getProperty(capName);
	}

	public static Capabilities setCapability() {
		caps = new DesiredCapabilities();
		loadConfig();
		Set set = prop.entrySet();
		Iterator itr = set.iterator();
		while (itr.hasNext()) {
			Map.Entry entry = (Map.Entry) itr.next();
			caps.setCapability((String) entry.getKey(), entry.getValue());
			
		}
		return caps;

	}

	public static AndroidDriver<AndroidElement> setUp() {
		try {
			driver = new AndroidDriver<AndroidElement>(new URL("http://172.26.16.59:4723/wd/hub"), setCapability());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

	public static void waitForElementToVisible(WebElement ele) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public static void clickOnElement(WebElement ele) {
		ele.click();

	}

	public static void typeTextInElement(WebElement ele, String str) {
		ele.sendKeys(str);

	}

}
