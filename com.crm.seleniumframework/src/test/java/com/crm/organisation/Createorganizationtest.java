package com.crm.organisation;

import org.testng.annotations.Test;

import com.crm.generic_utility.Baseclass;
import com.crm.generic_utility.Excel_utitlity;
import com.crm.generic_utility.File_utility;
import com.crm.generic_utility.Java_utility;
import com.crm.generic_utility.Webdriver_utility;
import com.crm.objectRepository.Homepage;
import com.crm.objectRepository.Loginpage;
import com.crm.objectRepository.Organizationcreatepage;
import com.crm.objectRepository.Validationandverification;

public class Createorganizationtest extends Baseclass {
		@Test(retryAnalyzer = com.crm.generic_utility.Retryanalyzer1.class)
		public void CreateOrganization() throws Throwable  {

			File_utility f= new File_utility();
			Java_utility j= new Java_utility();
			Webdriver_utility w= new Webdriver_utility();
			Excel_utitlity e= new Excel_utitlity();

			

			int Rannum = j.getRandomnum();

			w.getImplicitwait(driver);
			/*String URL = f.getpropertyKeyValue("url");
			String username  =f.getpropertyKeyValue("un");
			String password=f.getpropertyKeyValue("pwd");
			driver.get(URL);
			Loginpage l = new Loginpage(driver);
			l.login(username, password);*/

			Homepage h= new Homepage(driver);
			h.clickorganization();

	       
			String value = e.getExcelData("sheet1", 0, 0)+Rannum;  //this is using normal method
			//	String value = e.fetchData("sheet1", 0, 0)+Rannum;  //using data formatter
			Organizationcreatepage o= new Organizationcreatepage(driver);
			o.createorgplusimage();
			o.passaccountname(value);
		
			o.savebtn();

			//driver.findElement(By.name("accountname")).sendKeys(value);
			//driver.findElement(By.name("button")).click();
			Validationandverification v= new Validationandverification(driver);
			v.organizationvalidation(driver, value);
			/*String verify = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(verify.contains(value)) {
				System.out.println("tc is pass");
			}else {
				System.out.println("tc is fail");
			}*/

          System.out.println("logged out succesfully");
          System.out.println("hii its me finally block");

			h.clickOnSignout();

		}
	}


