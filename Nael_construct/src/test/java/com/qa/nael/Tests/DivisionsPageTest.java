package com.qa.nael.Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.nael.factory.PlaywrightFactory;
import com.qa.nael.pages.AboutPage;
import com.qa.nael.pages.DivisionsPage;

public class DivisionsPageTest {
	PlaywrightFactory pf;
	Page page;
	DivisionsPage divpage;
	@BeforeTest
	public void setUp() {
		pf = new PlaywrightFactory();
		page = pf.initBrowser();
		divpage = new DivisionsPage(page);
	}
  @Test(enabled = true, priority = 1)
  public void verifyDivisionsTest() {
	  divpage.verifyDivisions();
  }
  @Test(enabled = true, priority = 2)
  public void verifyClickonPrecatFactoryTest() {
	  divpage.verifyClickonPrecastFactory();
  }
  @Test(enabled = true, priority = 3)
  public void verifyBottomFactoriesTest() {
	  divpage.verifyClickonPrecastFactory();
	  divpage.verifyBottomFactories();
  }
  @Test(enabled = true, priority = 4)
  public void clickonBottomFactoriesTest() {
	  divpage.verifyClickonPrecastFactory();
	  divpage.clickonBottomFactories();
  }
  @Test(enabled = true, priority = 5)
  public void verifyClickonBlockFactoryTest() {
	  divpage.verifyClickonBlockFactory();
	  
  }
  @Test(enabled = true, priority = 6)
  public void verifyBottomFactoryforBlockFactoryTest() {
	  divpage.verifyBottomFactoryforBlockFactory();
	  
  }
  @Test(enabled = true, priority = 7)
  public void clickonBottomFactoryforBlockFactoryTest() throws InterruptedException {
	  divpage.clickonBlockFactoriesonBottom();
	  
  }
  @Test(enabled = true, priority = 8)
  public void verifyClickonSisterConcernsTest() {
	  divpage.verifyClickonSisterConcerns();
	  
  }
  @Test(enabled = true, priority = 9)
  public void verifyListedSistorConcernsTest() throws InterruptedException {
	  divpage.verifyListedSistorConcerns();
	  
  }  @AfterTest()
	public void tearDown(){
		page.context().browser().close();
	}
}
