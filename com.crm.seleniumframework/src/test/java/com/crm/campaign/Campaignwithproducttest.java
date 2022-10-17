package com.crm.campaign;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.generic_utility.Baseclass;
import com.crm.generic_utility.Excel_utitlity;
import com.crm.generic_utility.File_utility;
import com.crm.generic_utility.Java_utility;
import com.crm.generic_utility.Webdriver_utility;
import com.crm.objectRepository.Campaigncreatepage;
import com.crm.objectRepository.Homepage;
import com.crm.objectRepository.Loginpage;
import com.crm.objectRepository.Productcreatepage;

public class Campaignwithproducttest extends Baseclass {
	@Test(groups = "smoketest")
	public void CampaignWithProucttest() throws Throwable {

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


		String productname = e.getExcelData("sheet1", 0, 0)+Rannum;
		Homepage h=new Homepage(driver);
		h.clickOnProducts();
		Productcreatepage p= new Productcreatepage(driver);
		p.clickproductsplusimg();
		//driver.findElement(By.xpath("//a[.='Products']")).click();
		//driver.findElement(By.xpath("(//img[@title='Create Product...'])")).click();
		/*FileInputStream fis1= new FileInputStream("./Book1.xlsx");
		Workbook book= WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String productname =cell.getStringCellValue()+Rannum;*/
		System.out.println(productname);
		p.passData(productname);
		p.savebutton();
		//	driver.findElement(By.name("productname")).sendKeys(productname);
		//	driver.findElement(By.name("button")).click();
		h.clickOnMore();

		//driver.findElement(By.xpath("//a[.='More']")).click();
		//driver.findElement(By.name("Campaigns")).click();
		String value1 = e.getExceldata2("sheet1", 0, 0)+Rannum;

		System.out.println(value1);
		Campaigncreatepage c= new Campaigncreatepage(driver);
		c.clickcampaignpluimage();
		c.clickcampaigntextfield(value1);


		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//driver.findElement(By.name("campaignname")).sendKeys(value1);

		driver.findElement(By.xpath("//img[@title='Select']")).click();

		w.switchToWindow(driver, "Products&action");
		driver.findElement(By.id("search_txt")).sendKeys(productname);
		driver.findElement(By.name("search")).click();
		//dynamic xpath
		driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
		//Switch back Window
		w.switchToWindow(driver, "Campaigns&action");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();


		h.clickOnSignout();


	}

}
