package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
@Listeners(com.crm.qa.Listener.MyListener.class)
public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public ContactsPageTest(){
		
		super();
		
		
	}
	
	
	@BeforeMethod
	
	public void setup() {
		initialization();
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil=new TestUtil();
		
		testUtil.switchToFrame();
		
		contactsPage=homePage.clickOnContactsLink();
	}
	
	
	@Test(priority=1)
	
	public void ValidateContactLabel() {
		contactsPage.validateContactLabel();
	}

	
	@Test(priority=2)
	public void searchUserValidation() {
		contactsPage.searchUser(prop.getProperty("useremail"));
	}
	
	@DataProvider
	public Object[][] getDataFromExcel(){
		
		Object[][] data=TestUtil.getTestData("testdata");
		return data;
		
	}
	
	@Test(priority=3,dataProvider="getDataFromExcel")
	public void validateCreateNewConatct(String title,String firstName,String lastName,String email) throws InterruptedException {
	
	homePage.clickOnNewContact();
	
	contactsPage.createNewContact(title, firstName, lastName, email);
		
	}
	
	@AfterMethod
	
	public void teardown() {
		driver.quit();
	}
}
