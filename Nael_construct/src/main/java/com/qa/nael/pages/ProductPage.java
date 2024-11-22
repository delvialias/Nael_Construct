package com.qa.nael.pages;

import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage {
	Page page;
	private String productlink = "a[href=\"/en/products\"]";
	private String productlistcontainer = "div[class=\"tailwind-container mx-auto grid grid-cols-3 gap-3 my-4 \"]";
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
	public void verifytheProductName() {
		page.locator(productlink).click();
		//get the number of products in list
		
		page.waitForSelector(productlistcontainer).waitForSelector("div");
		List<String> productNames = page.locator(productlistcontainer).locator("div>div>a>p").allTextContents();
		
		for(String text : productNames) {
			System.out.println(text);
			}
		List<String> expectedTexts = List.of("Precast", "Prestressed Hollow Cores Labs", "Mansonry Blocks", "Interlocking Pavers", "KerbStones/Cable Tiles/Roof Tiles", "Cable Tiles",
				 "Roof Tiles", "Readymix Concrete", "GRC/GRP/GRG");
		// Verify the size of the lists
        Assert.assertEquals(productNames.size(), expectedTexts.size(), "Mismatch in the number of products.");

        // Verify each product name
        for (int i = 0; i < productNames.size(); i++) {
            Assert.assertEquals(productNames.get(i), expectedTexts.get(i), "Mismatch at index " + i);
        }

        System.out.println("All product names are verified successfully!");
	
	}
	public void clickontheProductslink() {
		page.locator(productlink).click();
		page.waitForSelector(productlistcontainer).waitForSelector("div");
		List<Locator> products = page.locator(productlistcontainer).locator("div[class=\"col-span-3 sm:col-span-3 md:col-span-1\"]").all();
		for(int i =1; i<=products.size();i++) {
			page.locator(productlistcontainer).locator("div:nth-child("+i+")>div>a").click();
			page.goBack();
		}

	}
}
