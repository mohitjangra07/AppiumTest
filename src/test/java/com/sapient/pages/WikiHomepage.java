package com.sapient.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikiHomepage {
	
	WebDriverWait wait;
	WebDriver driver;
	
	
	@FindBy(id = "searchInput")
	private WebElement searchBox;
	
	@FindBy(xpath = "//form[@id='search-form']/fieldset/button/i")
	private WebElement searchButton;
	
	
	public WikiHomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSearchBox() {
		searchBox.click();
	}
	
	public void enterSearchQuery(String keys) {
		searchBox.sendKeys(keys);
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	public String titleHomepage() {
		return driver.getTitle();
	}

}
