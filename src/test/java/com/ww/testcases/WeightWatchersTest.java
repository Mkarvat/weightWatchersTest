package com.ww.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ww.base.TestBase;
import com.ww.pages.HomePage;
import com.ww.pages.SearchResultPage;
import com.ww.utils.TestUtils;


public class WeightWatchersTest extends TestBase {
	
	HomePage homePage;
	SearchResultPage searchPage;
	TestUtils testUtil;

	public WeightWatchersTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		homePage = new HomePage();
		searchPage = new SearchResultPage();
		testUtil = new TestUtils();	
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA");	
	}
	
	@Test(priority=2)
	public void verifyWorkshopTitle(){
		String workshopTitle = homePage.verifyWorkshopTitle();
		Assert.assertEquals(workshopTitle, "Find WW Studios & Meetings Near You | WW USA");
	}
	
	@Test(priority=3)
	public void verifyFirstSearchResult(){
		searchPage.searchWorkshop();
		String searchResult = searchPage.printFirstSearchResult();
		searchPage.printFirstSearchResultDistance();
		searchPage.clickFirstSearchResult();
		Assert.assertEquals(searchPage.getSearchResult(), searchResult);	
	}
	
	@Test(priority=4)
	public void printHoursOfOperation(){
		searchPage.printHoursOfOperation();	
	}
	
	@Test(priority=5)
	public void printMeetings(){
		searchPage.printNoOfMeetingsPerPerson();	
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}


	