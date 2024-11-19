package com.qa.nael.Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.nael.factory.PlaywrightFactory;
import com.qa.nael.pages.NaelReadyMixPage;
import com.qa.nael.pages.ProjectsPage;

public class ProjectsPageTest {
	PlaywrightFactory pf;
	Page page;
	ProjectsPage projects;
	@BeforeTest
	public void setUp() {
		pf = new PlaywrightFactory();
		page = pf.initBrowser();
		projects = new ProjectsPage(page);
	}
  @Test(enabled = true, priority = 1)
  public void verifyProjectlinkTest() throws InterruptedException {
	  projects.verifyProjectsLink();
  }
  @Test(enabled = true, priority = 2)
  public void verifyProjects() throws InterruptedException {
	  projects.verifyProjectsLink();
	  projects.verifyProjectsListed(); 
  }
  @Test(enabled = true, priority = 3)
public void verifyOtherProjects() throws InterruptedException {
	  projects.verifyProjectsLink();
	  projects.verifyOtherProjects();
  }
  @AfterTest()
	public void tearDown(){
		page.context().browser().close();
	}
}
