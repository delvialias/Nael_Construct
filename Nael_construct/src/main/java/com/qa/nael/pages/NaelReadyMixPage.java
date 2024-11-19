package com.qa.nael.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class NaelReadyMixPage {
	private String naelreadymixgallerygrid = "div[class=\"grid grid-cols-2 gap-3\"]";

	Page page;
public NaelReadyMixPage(Page page) {
	this.page = page;
}
public void verifynaelReadyMix() {
Locator gallery = page.locator("body > div:nth-child(1) > main:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div");
System.out.println(gallery.count());
}
}
