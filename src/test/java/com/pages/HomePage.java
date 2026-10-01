package com.pages;

import org.openqa.selenium.By;

import com.constant.Browser;
import com.utitlity.BrowserUtitlity;

public class HomePage extends BrowserUtitlity{
	
	private static final By USER_NAME_LOCATOR=By.id("user-name");
	private static final  By PASSWORD_LOCATOR=By.id("password");
	private static final By LOGIN_BTN_LOCATOR=By.id("login-button");
	public HomePage(Browser browserName) {
		super(browserName);
		goToWebsite("https://www.saucedemo.com/");
	}
	
	public ProductPage login(String userName, String password) {
		fillTextbox(USER_NAME_LOCATOR, userName);
		fillTextbox(PASSWORD_LOCATOR, password);
		clickBtn(LOGIN_BTN_LOCATOR);
		return new ProductPage(getDriver());
		
	}
	
	

}
