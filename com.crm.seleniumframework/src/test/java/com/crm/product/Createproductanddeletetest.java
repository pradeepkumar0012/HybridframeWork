package com.crm.product;

import org.testng.annotations.Test;

import com.crm.generic_utility.Baseclass;
import com.crm.generic_utility.Excel_utitlity;
import com.crm.generic_utility.File_utility;
import com.crm.generic_utility.Java_utility;
import com.crm.generic_utility.Webdriver_utility;
import com.crm.objectRepository.Homepage;
import com.crm.objectRepository.Loginpage;
import com.crm.objectRepository.Productcreatepage;

public class Createproductanddeletetest  extends Baseclass {
	@Test
	public void CreateProductandDeletetest() throws Throwable {

		File_utility f= new File_utility();
		
		Webdriver_utility w= new Webdriver_utility();
		
		Excel_utitlity e= new Excel_utitlity();
		Java_utility j= new Java_utility();

		w.getImplicitwait(driver);
		int Rannum = j.getRandomnum();

	/*	String URL = f.getpropertyKeyValue("url");
		String username  =f.getpropertyKeyValue("un");
		String password=f.getpropertyKeyValue("pwd");
		driver.get(URL);
		Loginpage l = new Loginpage(driver);
		l.login(username, password);*/
		Homepage h=new Homepage(driver);
		h.clickOnProducts();
		String value = e.getExcelData("sheet1", 0, 0)+Rannum;
		System.out.println(value);
		Productcreatepage p= new Productcreatepage(driver);
		p.clickproductsplusimg();
		p.passData(value);
		p.savebutton();
		//delete product
		p.Deletebutton();
		w.switchToalertandaccept(driver);
		//Alert a = driver.switchTo().alert();// without webdriver utility
		//a.accept();
		h.clickOnSignout();

	}
}