

package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaigncreatepage {

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement campaignplusimg;
	@FindBy(name="campaignname")
	private WebElement campaigntextfield;
	@FindBy(name="button")
	private WebElement savebuton;
	
	
	public WebElement getCampaignplusimg() {
		return campaignplusimg;
	}

	public WebElement getCampaigntextfield() {
		return campaigntextfield;
	}

	public WebElement getSavebuton() {
		return savebuton;
	}

	// initialization
	public Campaigncreatepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//business value for plus image 
	public void clickcampaignpluimage() {
		campaignplusimg.click();
		
	}
	//business vale for passing the data into textfield
	public String clickcampaigntextfield(String data) {
		campaigntextfield.sendKeys(data);
		return data;
		
	}
	//business class for save button 
	public void clicksavebutton() {
		savebuton.click();
	}
}
