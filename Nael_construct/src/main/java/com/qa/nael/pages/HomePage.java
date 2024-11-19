package com.qa.nael.pages;

import java.nio.file.Paths;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.nael.factory.PlaywrightFactory;
import com.qa.nael.pages.HomePage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class HomePage {
	Page page;
//string locators
	private String search = "input[placeholder='Search']";
	private String searchlist = "div[class=\"custom-scrollbar max-h-[500px]  overflow-y-auto\"]";
	private String slickslider = "div[class=\"slick-slide slick-active slick-current\"] >> nth=0";
	private String slickdots = "ul[class=\"slick-dots slick-thumb slickDotsDivWidthOne\"]";
	private String headerbar = "div[class=\"bg-[#00A551] w-full\"]:nth-child(1)";
	private String facebook = "svg[class=\"cursor-pointer  top-banner-svg-icon\"]";
	private String twitter = "div[class=\"bg-[#00A551] w-full\"]:nth-child(1)>div>div:nth-child(1)>svg";
	private String productsslicklist = "div[class=\"pb-[100px] md:pb-[120px] px-3 sm:px-0\"]";
	private String productsslickdots = "div[class='slick-slider slick-initialized'] ul[class='slick-dots']";
	private String projectlistheader = "div[class=\"flex justify-between items-center\"]";
	private String projectlistcontainer = "div[class=\"slick-slider featured-products-slider slick-initialized\"]";
	private String projectslickslots = "div[class='slick-slider featured-products-slider slick-initialized'] ul[class='slick-dots']";
	private String footer = "footer[class=\"grid grid-cols-6 gap-4  tailwind-container mx-auto px-3 sm:px-0\"]";
	private String map = "div[class=\"map-block\"]";
//page constructor
	public HomePage(Page page) {
		this.page = page;
	}
//page actions/ methods
	public void doSearch(String searchtext) throws InterruptedException {
		//fill value in search box
		page.fill(search, searchtext);
		//get all search results
		List<Locator> alllocatorsforsearchlist = page.locator(searchlist).locator("a").all();
		int sizeofsearchlist = alllocatorsforsearchlist.size();
		System.out.println(sizeofsearchlist);
		for(int i=0;i<sizeofsearchlist;i++){
			String textinsearchlist = page.locator(searchlist).locator("a>>nth="+i).textContent();
			if(textinsearchlist==searchtext) {
				//click on search result
				page.locator(searchlist).locator("a>>nth="+i).click();
			}
		}
		
	}
	//verify url of the page is correct 
	public String getUrl() {
		String pageurl = page.url();
		return pageurl;
	}
	//verify the description in home page
	public String verifyDescription() {
		String sicksliderdesc = page.locator(slickslider).locator("div>div>p").textContent();
		return sicksliderdesc;
	}
	public void clickonSlickbuttons() throws InterruptedException {
		Locator slickdotselements = page.locator(slickdots).locator("li");
		System.out.println(slickdotselements.count());
		for(int i=0;i<slickdotselements.count();i++) {
			page.locator(slickdots).locator("li>>nth="+i).click();
			Thread.sleep(3000);
		}
	}
	public void verifySocialMediaButtons() throws InterruptedException {
		//verify and click on facebbok
		//page.locator(headerbar).locator("div>div>>nth=0>a>>nth=0").click();
		boolean facebookbutton = page.locator(facebook).isVisible();
		Assert.assertEquals(facebookbutton, true);
		System.out.println("facebook button was displayed on header bar");
		//verify facebook was opened correctly
		Page newtab = page.waitForPopup(()->{
		page.locator(facebook).click();}
		);
		//newtab.waitForLoadState();
		String facebookurl = newtab.url();
		Assert.assertEquals(facebookurl, "https://www.facebook.com/ngcalain");
		System.out.println("facebook was opened correctly");
		//verify and click twitter
		boolean twittervisibility =page.locator(headerbar).locator("div>div:nth-child(1)>svg>g").isVisible();
		Assert.assertEquals(twittervisibility, true);
		System.out.println("twitter link was displayed correctly");
		page.locator(headerbar).locator("div>div:nth-child(1)>svg").click();
		//verify and click on instagram
		boolean instagramvisibility = page.locator(headerbar).locator("div>div:nth-child(1)>a:last-child").isVisible();
		Assert.assertEquals(instagramvisibility,true);
		System.out.println("Instagram was displayed correctly");
		page.locator(headerbar).locator("div>div:nth-child(1)>a:last-child").click();
	}
	public void verifyContactButton() {
		//verify contact button is present
		boolean contactelementvisibility = page.locator(headerbar).locator("div>div:nth-child(2)>a:nth-child(4)>div>p").isVisible();
		Assert.assertEquals(contactelementvisibility, true);
		System.out.println("contact element was displayed");
		//verify the contact text
		String contacttext = page.locator(headerbar).locator("div>div:nth-child(2)>a:nth-child(4)>div>p").textContent();
		Assert.assertEquals(contacttext, "CONTACT");
		System.out.println("Contact text was displayed correctly");
		//clicking on contact
		page.locator(headerbar).locator("div>div:nth-child(2)>a:nth-child(4)").click();
		System.out.println("user was able to click on contact button successfully");
	}
	public void verifyENandAR() {
		//verify EN
		boolean envisibility = page.locator(headerbar).locator("div>div:last-child>div>span:nth-child(1)").isVisible();
		Assert.assertEquals(envisibility, true);
		System.out.println("EN was displayed");
		//click on EN
		page.locator(headerbar).locator("div>div:last-child>div>span:nth-child(1)").click();
		//verify AN
		boolean anvisibility = page.locator(headerbar).locator("div>div:last-child>div>span:nth-child(2)").isVisible();
		Assert.assertEquals(anvisibility, true);
		System.out.println("AN was displayed");
	}
	public void verifyProducts() throws InterruptedException {
		//get the total products in production section
		Locator productspage=page.locator(productsslicklist).locator("div>div>div>div>div>div>div>img");
		System.out.println(productspage.count());
		for (int i =1;i<=productspage.count();i++) {
			String products = page.locator(productsslicklist).locator("div>div>div>div>div:nth-child("+i+")>div>div>div>div>p:nth-child(1)").textContent();
			System.out.println(products);
			String produdesc = page.locator(productsslicklist).locator("div>div>div>div>div:nth-child("+i+")>div>div>div>div>p:nth-child(2)").textContent();
			System.out.println(produdesc);
		}
		//clicking on dots
			Locator slickdots = page.locator(productsslickdots).locator("li");
			System.out.println(slickdots.count());
			for(int i =1;i<=slickdots.count();i++) {
				page.locator(productsslickdots).locator("li:nth-child("+i+")>div").click();
				
			}
	}
	public void verifyFeaturedProject() throws InterruptedException {
		//verify featured project header
		String projectheader = page.locator(projectlistheader).locator("p").textContent();
		Assert.assertEquals(projectheader, "Our Featured Project");
		System.out.println("Project list header was correct");
		//verify view all projects button
		boolean viewallprojectsbuttonvisibility = page.locator(projectlistheader).locator("a").isVisible();
		Assert.assertEquals(viewallprojectsbuttonvisibility, true);
		System.out.println("view all projects button was displayed");
		//click on view all projects link
		//page.locator(projectlistheader).locator("a").click();
		
			page.locator(projectlistheader).locator("a").click();
			Thread.sleep(3000);

			//newtab.waitForLoadState();
			String projectpageurl = page.url();
			System.out.println(projectpageurl);
		//verify the page opened
		//String projectpageurl = page.url();
		//Assert.assertEquals(projectpageurl,"https://nael-cement-products.vercel.app/en/project");
		//System.out.println("User was taken to correct page when click on view all projects link");
		//back to home page
			page.goBack();
		Locator projectpagelist = page.locator(projectlistcontainer).locator("div>div>div>div>div>img");
		System.out.println(projectpagelist.count());
		for (int i =1;i<=projectpagelist.count();i++) {
			String project = page.locator(projectlistcontainer).locator("div>div>div:nth-child("+i+")>div>div>div>p:nth-child(1)").textContent();
			System.out.println(project);
			String projecdesc = page.locator(projectlistcontainer).locator("div>div>div:nth-child("+i+")>div>div>div>p:nth-child(2)").textContent();
			System.out.println(projecdesc);
		}
		//clicking on dots
			Locator slickdots = page.locator(projectslickslots).locator("li");
			System.out.println(slickdots.count());
			for(int i =1;i<=slickdots.count();i++) {
				page.locator(projectslickslots).locator("li:nth-child("+i+")>div").click();
				
			}
	}
	public void submittingEnquiryForm() {
		//verify the header of enquiry form
		String enquireformheader = page.locator(footer).locator("div:nth-child(2)>form>p").textContent();
		Assert.assertEquals(enquireformheader, "Enquire");
		//fill name
		page.locator(footer).locator("div:nth-child(2)>form>div:nth-child(2)>div:nth-child(1)>input").fill("Delvi");
		//fill email
		page.locator(footer).locator("div:nth-child(2)>form>div:nth-child(2)>div:nth-child(2)>input").fill("Test@mail.com");
		//fill phone
		page.locator(footer).locator("div:nth-child(2)>form>div:nth-child(2)>div:nth-child(3)>input").fill("12345678");
		//fill message
		page.locator(footer).locator("div:nth-child(2)>form>div:nth-child(3)>textarea").fill("Test message");
		//click on submit
		page.locator(footer).locator("div:nth-child(2)>form>div:nth-child(3)>button").click();
	}
	public void clickMap() {
		page.locator(map).locator("a").click();
		System.out.println(page.url());
		
	}
}
