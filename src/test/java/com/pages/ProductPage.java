package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utitlity.BrowserUtitlity;

public class ProductPage extends BrowserUtitlity{
	private static final By PRODUCT_TEXT_LOCATOR= By.xpath("//span[@data-test='title']");

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	public boolean isProductTextVisible() {
		return isLocatorPresent(PRODUCT_TEXT_LOCATOR);
		
	}

}
