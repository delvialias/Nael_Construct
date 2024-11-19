package com.qa.nael.Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.nael.factory.PlaywrightFactory;
import com.qa.nael.pages.NaelReadyMixPage;

public class NaelReadMixTest {
	PlaywrightFactory pf;
	Page page;
	NaelReadyMixPage naelreadmix;
	@BeforeTest
	public void setUp() {
		pf = new PlaywrightFactory();
		page = pf.initBrowser();
		naelreadmix = new NaelReadyMixPage(page);
	}

  @Test
  public void verifyNaelMixGalleryTest() {
	  naelreadmix.verifynaelReadyMix();
  }
  @AfterTest()
	public void tearDown(){
		page.context().browser().close();
	}
}
