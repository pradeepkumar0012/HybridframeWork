package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	//declaration
	//for organisation
	@FindBy(xpath="//a[.='Organizations']")
	private  WebElement organisations;
	
	// for products 
	@FindBy(xpath="//a[.='Products']")
	private WebElement products;
	
	// for  morelink
	@FindBy(xpath="//a[.='More']")
	
	
	private WebElement more;
	@FindBy(name="Campaigns")
	
	private WebElement campaign;
	
	// for signout
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrator;
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signoutbtn;
	
	//initialisation
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganisations() {
		return organisations;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getMore() {
		return more;
	}

	public WebElement getCampaign() {
		return campaign;
	}

	
	public WebElement getAdministrator() {
		return administrator;
	}

	public WebElement getSignoutbtn() {
		return signoutbtn;
	}

	
	//business classes for organization
	public void  clickorganization() {
	organisations.click();
	
	}
	//business class for products
	public void clickOnProducts() {
		products.click();
	}

	//business class for more 
	public void  clickOnMore() {
		more.click();	
		campaign.click();
	}


	// business class for signout 
	
	public void clickOnSignout() {
		administrator.click();
		signoutbtn.click();
	}
}
