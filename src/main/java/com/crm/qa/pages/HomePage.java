package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;


public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: PANKAJ KUMAR')]")
	WebElement userNameLabel;
	
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactLink;
	
	public HomePage(){
		PageFactory.initElements(driver,this);
	}
	
	
	//Actions
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	
	public void verifyUserName() {
		String user=userNameLabel.getText();
		Assert.assertEquals(user,"  User: PANKAJ KUMAR","incorrect user");
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContact() throws InterruptedException {
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink);
		Thread.sleep(20000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",newContactLink);
		
		
		
	}
	

}
