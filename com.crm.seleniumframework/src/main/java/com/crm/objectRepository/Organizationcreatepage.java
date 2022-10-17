package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationcreatepage {

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createorglink;
	@FindBy(name="accountname")
	private WebElement accountname;
	@FindBy(name="button")
	private WebElement savebutton;
	//initialization
	public Organizationcreatepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreateorglink() {
		return createorglink;
		
		
		
	}
	public WebElement getAccountname() {
		return accountname;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	
	//busines value classes 
	public void createorgplusimage() {
		createorglink.click();
	}
	public String passaccountname(String data) {
		accountname.sendKeys(data);
		return data;
		
	}
	public void savebtn() {
		savebutton.click();
	}
	
	
	
}
