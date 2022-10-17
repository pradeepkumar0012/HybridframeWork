package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	//declaration
	@FindBy(name="user_name")
	 private WebElement user_name;
	@FindBy(name="user_password")
	 private WebElement pass_word;
	@FindBy	(id="submitButton")
	private WebElement button;
		//initialisation
	public Loginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getUser_name() {
		
		return user_name;
	}
	public WebElement getPass_word() {
		return pass_word;
		
		
	}
	public WebElement getButton() {
		return button;
	}
	
	/**
	 * this method is used to login to the application
	 */
	public void login(String username, String password) {
		user_name.sendKeys(username); 	
		pass_word.sendKeys(password);
		button.click();
	}

}
