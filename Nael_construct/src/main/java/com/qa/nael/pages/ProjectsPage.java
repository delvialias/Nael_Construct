package com.qa.nael.pages;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProjectsPage {
Page page;
private String projectlink = "a[href=\"/en/project\"]";
private String projectcontainer = "div[class=\"col-span-3 sm:col-span-3 md:col-span-1 mb-3\"]";
private String otherprojectlist = "div[class=\"tailwind-container mx-auto gap-3 my-4\"]";
public ProjectsPage(Page page) {
	this.page=page;
}
public void verifyProjectsLink() throws InterruptedException {
	//verify projects link is displayed
	boolean projectlinkvisibility = page.locator(projectlink).isVisible();
	Assert.assertEquals(projectlinkvisibility, true);
	System.out.println("Projects link was displayed");
	page.locator(projectlink).click();
	Thread.sleep(3000);
	//verify the project page url
	page.waitForURL("https://nael-cement-products.vercel.app/en/project");
	String projectpageurl = page.url();
	Assert.assertEquals(projectpageurl, "https://nael-cement-products.vercel.app/en/project");
}
public void verifyProjectsListed() throws InterruptedException {
	//get the number of projects
	Locator projectnumber = page.locator(projectcontainer).locator("div>div:nth-child(2)>a");
	System.out.println("Total number of projects : " +""+ projectnumber.count());
	for(int i=1;i<projectnumber.count();i++) {
	String projectstext = page.locator("div[class=\"col-span-3 sm:col-span-3 md:col-span-1 mb-3\"]:nth-child("+i+")>div>div:nth-child(2)>p:nth-child(1)").textContent();
	System.out.println(projectstext);
	//clicking on more info
	page.locator("div[class=\"col-span-3 sm:col-span-3 md:col-span-1 mb-3\"]:nth-child("+i+")>div>div:nth-child(2)>a").click();
	Thread.sleep(3000);
	page.goBack();
	}
	
}
public void verifyOtherProjects() {
	//verify other projects list header
	String otherprojlistheader = page.locator(otherprojectlist).locator("div>p").textContent();
	Assert.assertEquals(otherprojlistheader,"Other Projects");
	System.out.println("Other projects header was displayed correctly");
	//get the projects
	Locator projects = page.locator(otherprojectlist).locator("div>div>ul>li");
	System.out.println("Total number of other projects are : " + projects.count());
	for(int i =1;i<projects.count();i++) {
		String projectname = page.locator(otherprojectlist).locator("div>div>ul>li:nth-child("+i+")").textContent();
		System.out.println(projectname);
	}
}
}
