package com.qa.nael.pages;

import org.testng.Assert;

import com.microsoft.playwright.Page;

public class AboutPage {
	Page page;
	private String aboutbutton = "a[href=\"/en/about\"]";
	private String aboutsubmenulist = "div[class=\"absolute  top-6 z-50 w-[150px] bg-white rounded-md border border-1 border-gray-300\"]";
	public AboutPage(Page page) {
		this.page = page;
	}
	// verify the about sub menus
	public void verifyAbout()  {
		page.locator(aboutbutton).click();
		String accoladestext = page.locator(aboutsubmenulist).locator("a:nth-child(1)>p").textContent();
		Assert.assertEquals(accoladestext, "Accolades");
		System.out.println("Accolages submenu was dispalyed");
		page.locator(aboutsubmenulist).locator("a:nth-child(1)>p").click();
		String csrtext = page.locator(aboutsubmenulist).locator("a:nth-child(2)>p").textContent();
		Assert.assertEquals(csrtext, "CSR");
		System.out.println("csr submenu was dispalyed");
		page.locator(aboutsubmenulist).locator("a:nth-child(2)>p").click();

	}
	//clicking on accolages
	public void verifyAccolages() throws InterruptedException {
		//click on accolages
		page.locator(aboutbutton).click();
		
		page.locator(aboutsubmenulist).locator("a:nth-child(1)").dispatchEvent("click");
		// Wait until the URL is the expected URL
		page.waitForURL("https://nael-cement-products.vercel.app/en/accolades");
		//get the page url
		String accolagespageurl = page.url();
		System.out.println(accolagespageurl);
		Assert.assertEquals(accolagespageurl,"https://nael-cement-products.vercel.app/en/accolades");
		System.out.println("Accolages page url was correct");
		
	}
	//clicking on CSR
	public void verifyCSR() {
		page.locator(aboutbutton).click();
		page.locator(aboutsubmenulist).locator("a:nth-child(2)").dispatchEvent("click");
		page.waitForURL("https://nael-cement-products.vercel.app/en/csr");
		String csrurl = page.url();
		System.out.println(csrurl);
		Assert.assertEquals(csrurl,"https://nael-cement-products.vercel.app/en/csr");
		System.out.println("Csr page url was correct");

	}
}