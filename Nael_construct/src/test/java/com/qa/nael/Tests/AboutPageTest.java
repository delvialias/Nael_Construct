package com.qa.nael.Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.nael.factory.PlaywrightFactory;
import com.qa.nael.pages.AboutPage;


public class AboutPageTest {
	PlaywrightFactory pf;
	Page page;
	AboutPage aboutpage;
	@BeforeTest
	public void setUp() {
		pf = new PlaywrightFactory();
		page = pf.initBrowser();
		aboutpage = new AboutPage(page);
	}
  @Test(enabled =true, priority =1)
  public void verifyAboutTest() {
	  aboutpage.verifyAbout();
  }
  @Test(enabled = true, priority = 2)
  public void verifyAccolagesTest() throws InterruptedException {
	  aboutpage.verifyAccolages();
  }
  @Test(enabled = true, priority = 3)
  public void verifyCsrTest() throws InterruptedException {
	  aboutpage.verifyCSR();
  }
  @AfterTest()
	public void tearDown(){
		page.context().browser().close();
	}
}
