package com.ui.tests;

import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constant.Browser;
import com.pages.HomePage;
import com.utitlity.PropertiesUtil;

public class LoginTest {
	HomePage homePage;
	@BeforeMethod(description = "Load the Homepage of the Website")
	public void setUp() {
		
		homePage=new HomePage(Browser.CHROME);

		homePage.maximizeBrowser();
	}
	
	@Test(description = "Verifies if the valid user able to login", groups = {"sanity","smoke","function"})	
	public  void loginWithValidCredential() {
		
		assertTrue(homePage.login(PropertiesUtil.getProplety("Username"), PropertiesUtil.getProplety("password")).isProductTextVisible());
	}
	@AfterMethod
	public void teardown() {
		homePage.quitBrowser();
	}

}
