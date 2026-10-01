package com.utitlity;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constant.Browser;

public abstract class BrowserUtitlity {
	private WebDriver driver;
	private WebDriverWait wait;

	public BrowserUtitlity(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public BrowserUtitlity(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			  ChromeOptions options = new ChromeOptions();

		        Map<String, Object> prefs = new HashMap<>();
		        prefs.put("credentials_enable_service", false);
		        prefs.put("profile.password_manager_leak_detection", false);

		        options.setExperimentalOption("prefs", prefs);
		        driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
		} else {
				System.out.println("Please enter valid browser nmae");
		}

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	public BrowserUtitlity(Browser browserName) {
		if (browserName==Browser.CHROME) {
			ChromeOptions options = new ChromeOptions();
			
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_leak_detection", false);
			
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		} else if (browserName==Browser.EDGE) {
			driver = new EdgeDriver();
			
		} else if (browserName==Browser.FIREFOX) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Please enter valid browser nmae");
		}
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void goToWebsite(String url) {
		driver.get(url);
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public WebElement visibilityOfElementLocated(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void fillTextbox(By locator, String data) {
		visibilityOfElementLocated(locator).sendKeys(data);
	}

	public void clickBtn(By locator) {
		visibilityOfElementLocated(locator).click();
	}

	public boolean isLocatorPresent(By locator) {
		return visibilityOfElementLocated(locator).isDisplayed();
	}
	public void quitBrowser() {
		driver.quit();
	}
}
