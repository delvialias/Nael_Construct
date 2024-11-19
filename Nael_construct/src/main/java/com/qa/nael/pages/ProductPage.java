package com.qa.nael.pages;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage {
	Page page;
	private String productlink = "a[href=\"/en/products\"]";
	public ProductPage(Page page) {
		this.page = page;
	}
	public void verifyProducts() throws InterruptedException {
		page.locator(productlink).click();
		page.waitForURL("https://nael-cement-products.vercel.app/en/products");
		//verify products page url
		String producturl = page.url();
		System.out.println(producturl);
		Assert.assertEquals(producturl,"https://nael-cement-products.vercel.app/en/products");
		System.out.println("Product page url was correct");
		}
	
}
