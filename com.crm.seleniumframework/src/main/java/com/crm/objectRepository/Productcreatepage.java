package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productcreatepage {

	@FindBy(xpath="(//img[@title='Create Product...'])")
	private WebElement productsplusimage;
	@FindBy(name="productname")
	private WebElement productnametxt;
	@FindBy(name="button")
	private WebElement savebutton;
	@FindBy(name="Delete")
	private WebElement deletebutton;
	
	//initialization
	public Productcreatepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
		
		
	}

	public WebElement getProductsplusimage() {
		return productsplusimage;
	}

	public WebElement getProductnametxt() {
		return productnametxt;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	public WebElement getDeletebutton() {
		return deletebutton;
	}
	
	//business value for productpage
	public void  clickproductsplusimg() {
		productsplusimage.click();
	}
	//business value for passing the data 
	public String passData(String data) {
		productnametxt.sendKeys(data);
		return data;
		
	}
	// business class for save button 
	public void savebutton() {
		savebutton.click();
	}
	//business value for deletebutton
	public void Deletebutton() {
		deletebutton.click();
	}

	
}
