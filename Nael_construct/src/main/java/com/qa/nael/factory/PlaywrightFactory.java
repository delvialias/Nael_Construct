package com.qa.nael.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	Playwright playwright;
	Browser browser;
	Page page;
	public Page initBrowser() {
		playwright = Playwright.create();
		BrowserType[] browsers = {
                playwright.chromium(),
                //playwright.firefox(),
                //playwright.webkit()	
		
	};
		  for (BrowserType browserType : browsers) {
			  browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
			  page = browser.newPage();
			  page.navigate("https://nael-cement-products.vercel.app/en");
			  }
		return page;
		  }
	/*
	 * Playwright playwright; Browser browser; BrowserContext browserContext;
	 * private Page page;
	 * 
	 * public Page initBrowser(String browserName) { playwright =
	 * Playwright.create(); switch(browserName.toLowerCase()) { case "chromium":
	 * browser = playwright.chromium().launch(new
	 * BrowserType.LaunchOptions().setHeadless(false)); break;
	 * 
	 * 
	 * case "firefox": browser = playwright.firefox().launch(new
	 * BrowserType.LaunchOptions().setHeadless(false)); break;
	 * 
	 * 
	 * case "safari": browser = playwright.webkit().launch(new
	 * BrowserType.LaunchOptions().setHeadless(false)); break;
	 * 
	 * 
	 * case "chrome": browser = playwright.chromium().launch(new
	 * LaunchOptions().setChannel("chrome").setHeadless(false)); break; default:
	 * break; } browserContext = browser.newContext(); page =
	 * browserContext.newPage();
	 * page.navigate("https://nael-cement-products.vercel.app/en"); return page; }
	 */}
