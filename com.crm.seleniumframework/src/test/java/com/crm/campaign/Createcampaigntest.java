package com.crm.campaign;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.generic_utility.Baseclass;
import com.crm.generic_utility.Excel_utitlity;
import com.crm.generic_utility.File_utility;
import com.crm.generic_utility.Java_utility;
import com.crm.generic_utility.Webdriver_utility;
import com.crm.objectRepository.Campaigncreatepage;
import com.crm.objectRepository.Homepage;
import com.crm.objectRepository.Loginpage;
import com.crm.objectRepository.Validationandverification;

public class Createcampaigntest extends Baseclass {
    @Test(groups = {"smoketest","Regressiontest"})
	public void CreateCampaigntest() throws Throwable {
		File_utility f= new File_utility();
		Webdriver_utility w= new Webdriver_utility();
		Excel_utitlity e= new Excel_utitlity();
		Java_utility j= new Java_utility();


		w.getImplicitwait(driver);

		int Rannum = j.getRandomnum();

		//String URL = f.getpropertyKeyValue("url");
		//String username  =f.getpropertyKeyValue("un");
		//String password=f.getpropertyKeyValue("pwd");

		//driver.get(URL);
	//	Loginpage l = new Loginpage(driver);
	//	l.login(username, password);
		Homepage h=  new Homepage(driver);
		h.clickOnMore();
	//	Assert.assertEquals(true, false);
		String value = e.getExcelData("sheet1", 0, 0)+Rannum;
		System.out.println(value);
		Campaigncreatepage c= new Campaigncreatepage(driver);
		
		Thread.sleep(1000);
		c.clickcampaignpluimage();
		c.clickcampaigntextfield(value);
		c.clicksavebutton();

		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//driver.findElement(By.name("campaignname")).sendKeys(value);
		//driver.findElement(By.name("button")).click();
		//verification using assertions
		//Validationandverification v= new Validationandverification(driver);
		//v.campaignValidation(driver, value);
		/*String verify = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(verify.contains(value)) {
			System.out.println("tc is pass");
		}else {
			System.out.println("tc is fail");
		}*/


		h.clickOnSignout();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();

		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}
}
