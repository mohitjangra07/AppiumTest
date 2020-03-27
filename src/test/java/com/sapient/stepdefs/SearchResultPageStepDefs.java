package com.sapient.stepdefs;

import org.junit.Assert;

import com.sapient.pages.SearchResultPage;

import io.cucumber.java.en.Then;

public class SearchResultPageStepDefs {

	SearchResultPage searchResultPage = new SearchResultPage(BaseTestStepDef.getDriverInstance());

	@Then("I land on the page with heading {}")
	public void i_land_on_the_page_with_heading_Publicis_Sapient(String heading) {
		Assert.assertEquals(heading, searchResultPage.actualHeadingH1());
	}

	@Then("I see the page title as {}")
	public void i_see_the_page_title_as(String title) {
		Assert.assertEquals(title, searchResultPage.actualPageTitle());
	}

	@Then("I verify the ISIN number as FR0000130577")
	public void i_verify_the_ISIN_number_as_FR0000130577() {
		Assert.assertEquals("FR0X000130577", searchResultPage.actualISIN().trim());
	}

}
