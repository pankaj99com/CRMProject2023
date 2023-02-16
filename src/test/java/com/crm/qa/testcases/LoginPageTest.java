package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
@Listeners(com.crm.qa.Listener.MyListener.class)
public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test
	public void loginPageTitleValidation() {
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,prop.getProperty("loginpageTitle"));
	}
	
	@Test
	public void CRMLogoValidation() {
		boolean  status =loginPage.ValidateCRMLogo();
		Assert.assertTrue(status);
		
	}
	
	@Test
	public void loginTestValidation() {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
