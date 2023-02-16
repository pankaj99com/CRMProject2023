package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@name='cs_email']")
	WebElement emailField;
	
	@FindBy(xpath="//input[@value='Search']")
	WebElement searchBtn;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement newContactEmailField;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement newContactSaveBtn;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void validateContactLabel() {
		boolean contactVisibleText=contactsLabel.isDisplayed();
		Assert.assertTrue(contactVisibleText);
	}
	
	public void searchUser(String email) {
		emailField.sendKeys(email);
		searchBtn.click();
		
		WebElement searchedEmail=driver.findElement(By.xpath("//a[normalize-space()='"+email+"']"));
		String emailtxtResult=searchedEmail.getText();
		Assert.assertEquals(emailtxtResult, email);
		
	}
	
	
	public void createNewContact(String title,String fn,String ln,String email) {
		Select select =new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		newContactEmailField.sendKeys(email);
		newContactSaveBtn.click();
	}

}
