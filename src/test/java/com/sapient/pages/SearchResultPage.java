package com.sapient.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//h1[@id='section_0']")
	private WebElement HeadingH1;
	
	@FindBy(xpath = "//a[contains(text(),'ISIN')]/../..//td/span/a[1]")
	private WebElement ISIN;
	
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String actualHeadingH1() {
		return HeadingH1.getText();
	}
	
	public String actualPageTitle() {
		return driver.getTitle();
	}
	
	public String actualISIN() {
		return ISIN.getText();
	}

}
