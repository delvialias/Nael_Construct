package com.qa.nael.Tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.nael.factory.PlaywrightFactory;
import com.qa.nael.pages.HomePage;

public class HomePageTest {
	PlaywrightFactory pf;
	Page page;
	HomePage homepage;
	@BeforeTest
	public void setUp() {
		pf = new PlaywrightFactory();
		page = pf.initBrowser();
		homepage = new HomePage(page);
	}
	@Test(enabled = true, priority = 1)
	public void getHomePageUrl() {
		String actualUrl = homepage.getUrl();
		Assert.assertEquals(actualUrl, "https://nael-cement-products.vercel.app/en");
		System.out.println("The home page url was as per expected");
	}
	@Test(enabled =true, priority =2)
	public void searching() throws InterruptedException {
		homepage.doSearch("cable tiles");
		
	}
	@Test(enabled = true, priority =3)
	public void verifyDescriptionTest() {
		String actualdescription = homepage.verifyDescription();
		Assert.assertEquals(actualdescription, "The One Stop Shop For  All Your Concrete Product Requirements");
		}
	@Test(enabled = true, priority=4)
	public void clickonSlickDotsTest() throws InterruptedException {
		homepage.clickonSlickbuttons();
	}
	@Test(enabled = true, priority = 5)
	public void verifyandClickSocialMediaTest() throws InterruptedException {
		homepage.verifySocialMediaButtons();
	}
	@Test(enabled = true, priority = 6)
	public void verifycontactbuttontest() {
		homepage.verifyContactButton();
	}
	@Test(enabled = true, priority = 7)
	
	public void verifyENandANTest() {
		homepage.verifyENandAR();
	}
	@Test(enabled = true, priority = 8)
	public void verifyProductsTest() throws InterruptedException {
		homepage.verifyProducts();
	}
	@Test(enabled = true, priority = 9)
	public void verifyFeaturesProjectTest() throws InterruptedException {
		homepage.verifyFeaturedProject();
	}
	@Test(enabled = true, priority = 10)
	
	public void submittingEnquiryFormTest() {
		homepage.submittingEnquiryForm();
	}
	@Test(enabled = true, priority = 11)
	public void clickMapTest() {
		homepage.clickMap();
	}
	@AfterTest()
	public void tearDown(){
		page.context().browser().close();
	}
}
