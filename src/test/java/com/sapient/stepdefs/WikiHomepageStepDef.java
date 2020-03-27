package com.sapient.stepdefs;

import org.junit.Assert;

import com.sapient.pages.WikiHomepage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class WikiHomepageStepDef {

	WikiHomepage wikiHomePage = new WikiHomepage(BaseTestStepDef.getDriverInstance());

	@Given("I launched the Wikipedia Homepage")
	public void Given_I_launched_the_Wikipedia_Homepage() {
		Assert.assertEquals("Wikipedia", wikiHomePage.titleHomepage());
	}

	@When("I enter {} in HomePage search box")
	public void i_search_Publicis_Sapient_from_HomePage_search_box(String keys) {
		wikiHomePage.clickSearchBox();
		wikiHomePage.enterSearchQuery(keys);
	}

	@And("I click the search button")
	public void clickSearchButton() {
		wikiHomePage.clickSearchButton();
	}

}
