package com.crm.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.generic_utility.Baseclass;
import com.crm.generic_utility.Excel_utitlity;
import com.crm.generic_utility.File_utility;
import com.crm.generic_utility.Java_utility;
import com.crm.generic_utility.Webdriver_utility;
import com.crm.objectRepository.Homepage;
import com.crm.objectRepository.Loginpage;
import com.crm.objectRepository.Productcreatepage;
import com.crm.objectRepository.Validationandverification;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createproducttest extends Baseclass{
	@Test

	public void CreateProducttest() throws Throwable {

		File_utility f= new File_utility();
		Webdriver_utility w= new Webdriver_utility();
		Excel_utitlity e= new Excel_utitlity();
		Java_utility j= new Java_utility();

		
		w.getImplicitwait(driver);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		int Rannum = j.getRandomnum();

		/*String URL = f.getpropertyKeyValue("url");
		String username  =f.getpropertyKeyValue("un");
		String password=f.getpropertyKeyValue("pwd");
		driver.get(URL);
		Loginpage l = new Loginpage(driver);
		l.login(username, password);*/
		Homepage h= new Homepage(driver);
		h.clickOnProducts();

		//driver.findElement(By.xpath("//a[.='Products']")).click();
		//driver.findElement(By.xpath("(//img[@title='Create Product...'])")).click();

		
		String value = e.getExcelData("sheet1", 0, 0)+Rannum;
		System.out.println(value);
		Productcreatepage p=new Productcreatepage(driver);
		p.clickproductsplusimg();
		p.passData(value);
		p.savebutton();


		//driver.findElement(By.name("productname")).sendKeys(value);
		//driver.findElement(By.name("button")).click();
		Validationandverification v= new Validationandverification(driver);
		v.ProductValidation(driver, value);
		/*String verify = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
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
