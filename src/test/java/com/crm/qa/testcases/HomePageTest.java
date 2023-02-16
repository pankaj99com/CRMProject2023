package com.crm.qa.testcases;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;


@Listeners(com.crm.qa.Listener.MyListener.class)
public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	
	public HomePageTest(){
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
		testUtil=new TestUtil();
	}
	
	@Test
	public void homePageTitleTest() {
		String titleHome=homePage.verifyHomePageTitle();
		System.out.println(titleHome);
		Assert.assertEquals(titleHome,"CRMPRO");
	}
	
	@Test(priority=1)
	public void userValidation() {
		testUtil.switchToFrame();
		TestUtil.highLightElement(driver, driver.findElement(By.xpath("//td[contains(text(),'User: PANKAJ KUMAR')]")));
		homePage.verifyUserName();
	
	}
	
	@Test
	public void contactsLinkTest() {
		testUtil.switchToFrame();
		homePage.clickOnContactsLink();
		String contactPageTitle=driver.getTitle();
		System.out.println(contactPageTitle);
		Assert.assertEquals(contactPageTitle,"CRMPRO");
		
	
	}
	
	@Test
	public void dealsLinkTest() {
		testUtil.switchToFrame();
		homePage.clickOnDealsLink();
		String dealsPageTitle=driver.getTitle();
		System.out.println(dealsPageTitle);
		Assert.assertEquals(dealsPageTitle,"CRMPRO");
		
	
	}
	
	@Test
	public void tasksLinkTest() {
		testUtil.switchToFrame();
		homePage.clickOnTasksLink();
		String tasksPageTitle=driver.getTitle();
		System.out.println(tasksPageTitle);
		Assert.assertEquals(tasksPageTitle,"CRMPRO");
		
	
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
