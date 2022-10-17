package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validationandverification {
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement actorganization;

 public Validationandverification(WebDriver driver) {
	 PageFactory.initElements(driver, this);
 }

public WebElement getActorganization() {
	return actorganization;
}
 //businesss class
public void organizationvalidation(WebDriver driver,String data) {
	String actdata = actorganization.getText();
	if(actdata.contains(data)) {
		System.out.println("tc is pass");
	}else {
		
		
		
		
		System.out.println("tc is fail");
	}
}
//for campaign
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement actCampaign;

public WebElement getActCampaign() {
	return actCampaign;
}

public void campaignValidation(WebDriver driver,String data ) {
	String actcampaigndata = actCampaign.getText();
	if(actcampaigndata.contains(data)) {
		System.out.println("tc is pass");
	}else {
		System.out.println("tc is fail");
	}
	
	
	
	
}
//for product 
	@FindBy(xpath="//span[@class='lvtHeaderText']") 
	private WebElement actProduct;

	public WebElement getActProduct() {
		return actProduct;
	}
	public void ProductValidation(WebDriver driver, String data) {
		String actproductdata = actProduct.getText();
		if (actproductdata.contains(data)) {
			System.out.println("tc is pass");
		}else {
			System.out.println("tc is fail");
		}
	}

}
