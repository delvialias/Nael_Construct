package com.qa.nael.Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.nael.factory.PlaywrightFactory;
import com.qa.nael.pages.DivisionsPage;
import com.qa.nael.pages.ProductPage;

public class ProductPageTest {
	PlaywrightFactory pf;
	Page page;
	ProductPage productpage;
	@BeforeTest
	public void setUp() {
		pf = new PlaywrightFactory();
		page = pf.initBrowser();
		productpage = new ProductPage(page);
		}
	
  @Test(enabled = true, priority = 1)
  public void verifyProductsTest() throws InterruptedException {
	  productpage.verifyProducts();
  }
  @AfterTest()
	public void tearDown(){
		page.context().browser().close();
	}
  
}
