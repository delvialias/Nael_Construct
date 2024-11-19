package com.qa.nael.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
//import org.xml.sax.Locator;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DivisionsPage {
	Page page;
	private String divisionbutton = "div[class=\"realtive py-1 pl-5 pr-5\"]:nth-child(3)";
	private String divisionsmenulist = "div[class=\"absolute  top-6 z-50 w-[150px] bg-white rounded-md border border-1 border-gray-300\"]";
	private String bottomfactorylistcontainer = "div[class=\"grid grid-cols-3 gap-4 pt-5 tailwind-container  mx-auto px-3 sm:px-0 mb-5\"]";
	private String bottomblockfactorylistcontainer = "div[class=\"grid grid-cols-3 gap-4 pt-5 tailwind-container  mx-auto px-3 sm:px-0 mb-5\"]";
	private String sisterconcernslistcontainer = "div[class=\"grid grid-cols-1 gap-4 pt-10 \"]";
	public DivisionsPage(Page page) {
		this.page = page;
	}
	public void verifyDivisions() {
		//verify precast factory
		page.locator(divisionbutton).click();
		boolean precastfactory_visibility = page.locator(divisionsmenulist).locator("a:nth-child(1)>p").isVisible();
		Assert.assertEquals(precastfactory_visibility, true);
		System.out.println("precast factory was displayed");
		page.locator(divisionsmenulist).locator("a:nth-child(1)").click();
		//verify block factory
		boolean blockfactory  = page.locator(divisionsmenulist).locator("a:nth-child(2)>p").isVisible();
		Assert.assertEquals(blockfactory, true);
		System.out.println("block factory was displayed");
		page.locator(divisionsmenulist).locator("a:nth-child(2)").click();
		//verify sistor concerns
		boolean sisterconcerns  = page.locator(divisionsmenulist).locator("a:nth-child(3)>p").isVisible();
		Assert.assertEquals(sisterconcerns, true);
		System.out.println("sister concerns was displayed was displayed");
		page.locator(divisionsmenulist).locator("a:nth-child(3)").click();
	}
	public void verifyClickonPrecastFactory() {
		//click on precast factory
		page.locator(divisionbutton).click();
		page.locator(divisionsmenulist).locator("a:nth-child(1)").dispatchEvent("click");
		page.waitForURL("https://nael-cement-products.vercel.app/en/divisions/precast-factory");
		String precastfactorypageurl = page.url();
		Assert.assertEquals(precastfactorypageurl, "https://nael-cement-products.vercel.app/en/divisions/precast-factory");
		System.out.println("Precast factory page url was correct");
	}
	public void verifyBottomFactories() {
		List<Locator> bottomfactorylist = page.locator(bottomfactorylistcontainer).locator("div>a").all();
		int bottomfactorynumber = bottomfactorylist.size();
		System.out.println(bottomfactorynumber);
		//verify the bottom factories
		for(int i = 1;i<=bottomfactorynumber;i++) {
			boolean bottomfacoryvisibility = page.locator(bottomfactorylistcontainer).locator("div:nth-child("+i+")>a").isVisible();
			Assert.assertEquals(bottomfacoryvisibility, true);
			String factoryname =  page.locator(bottomfactorylistcontainer).locator("div:nth-child("+i+")>a").textContent();
			System.out.println(factoryname + "is listed on bottom");
		}
	}
	public void clickonBottomFactories() {
		List<Locator> bottomfactorylist = page.locator(bottomfactorylistcontainer).locator("div>a").all();
		int bottomfactorynumber = bottomfactorylist.size();
		for(int i = 1;i<=bottomfactorynumber;i++) {
			page.locator(bottomfactorylistcontainer).locator("div:nth-child("+i+")>a").click();
			page.goBack();
			page.locator(divisionbutton).click();
			page.locator(divisionsmenulist).locator("a:nth-child(1)").dispatchEvent("click");

		}
	}
	//click on block factories
	public void verifyClickonBlockFactory() {
		page.locator(divisionbutton).click();
		page.locator(divisionsmenulist).locator("a:nth-child(2)").dispatchEvent("click");
		page.waitForURL("https://nael-cement-products.vercel.app/en/divisions/block-factory");
		String blockfactoryurl = page.url();
		Assert.assertEquals(blockfactoryurl, "https://nael-cement-products.vercel.app/en/divisions/block-factory");
		System.out.println("Block factory url was correct");
	}
	public void verifyBottomFactoryforBlockFactory() {
		page.locator(divisionbutton).click();
		page.locator(divisionsmenulist).locator("a:nth-child(2)").dispatchEvent("click");
		//get the list of all bottom factories
		page.waitForSelector(bottomblockfactorylistcontainer);
		List<Locator> blockfactorybottomlist = page.locator(bottomblockfactorylistcontainer).locator("div>a").all();
		int blockfactories = blockfactorybottomlist.size();
		System.out.println("number of block factories" + blockfactories);
		//verify visibility of factories in bottom
		for(int i=1;i<blockfactories;i++){
			boolean blockfactoryinbottomvisibility = page.locator(bottomblockfactorylistcontainer).locator("div:nth-child("+i+")>a").isVisible();
			Assert.assertEquals(blockfactoryinbottomvisibility, true);
			String blockfactoryname = page.locator(bottomblockfactorylistcontainer).locator("div:nth-child("+i+")>a>div>p").textContent();
			System.out.println(blockfactoryname + "was displayed");
		}
	}
	public void clickonBlockFactoriesonBottom() throws InterruptedException {
		page.locator(divisionbutton).click();
		page.locator(divisionsmenulist).locator("a:nth-child(2)").dispatchEvent("click");
		page.waitForSelector(bottomblockfactorylistcontainer);
		List<Locator> blockfactorybottomlist = page.locator(bottomblockfactorylistcontainer).locator("div>a").all();
		int blockfactories = blockfactorybottomlist.size();
		for(int i=1;i<blockfactories;i++){
			page.locator(bottomblockfactorylistcontainer).locator("div:nth-child("+i+")>a").click();
			Thread.sleep(3000);
			page.goBack();
		}

	}
	//sister concerns
	public void verifyClickonSisterConcerns() {
		page.locator(divisionbutton).click();
		page.locator(divisionsmenulist).locator("a:nth-child(3)").dispatchEvent("click");
		page.waitForURL("https://nael-cement-products.vercel.app/en/divisions/sister-concerns");
		String blockfactoryurl = page.url();
		Assert.assertEquals(blockfactoryurl, "https://nael-cement-products.vercel.app/en/divisions/sister-concerns");
		System.out.println("Sister Concerns url was correct");
	}
	public void verifyListedSistorConcerns() throws InterruptedException {
		page.locator(divisionbutton).click();
		page.locator(divisionsmenulist).locator("a:nth-child(3)").dispatchEvent("click");
		page.waitForSelector(sisterconcernslistcontainer);
		List<Locator> sisterconcernlist = page.locator(sisterconcernslistcontainer).locator("div[class='grid grid-cols-11 mb-5 md:mb-10']").all();
		System.out.println("number of system concerns are" + "" + sisterconcernlist.size());
		for(int i =1;i<=sisterconcernlist.size();i++) {
			String sisterconcernheader = page.locator(sisterconcernslistcontainer).locator("div:nth-child("+i+")>div:nth-child(2)>h3").textContent();
			System.out.println(sisterconcernheader + "was displayed");
		}
	}
}
