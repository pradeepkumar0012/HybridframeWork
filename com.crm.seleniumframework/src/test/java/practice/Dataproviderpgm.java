package practice;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.generic_utility.Baseclass;
import com.crm.generic_utility.File_utility;
import com.crm.generic_utility.Java_utility;
import com.crm.generic_utility.Webdriver_utility;
import com.crm.objectRepository.Homepage;

public class Dataproviderpgm extends Baseclass {
	@Test(dataProvider="data_test")
	public void productdetails(String data,String yes,String no) throws Throwable {

		File_utility f= new File_utility();
		Webdriver_utility w= new Webdriver_utility();
		Java_utility j= new Java_utility();
		w.getImplicitwait(driver);
		Homepage h= new Homepage(driver);
		h.clickOnProducts();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(data);
		driver.findElement(By.xpath("//input[@id='mfr_part_no']")).sendKeys(yes);
		driver.findElement(By.id("serial_no")).sendKeys(no);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.quit();
		}
	@DataProvider
	public Object[][] data_test(){
		Object[][] objarr=new Object[3][3];
		objarr[0][0]="qspiders";
		objarr[0][1]="123";
		objarr[0][2]="1234";
		
		objarr[1][0]="akjduwe";
		objarr[1][1]="132";
		objarr[1][2]="1324";
		
		objarr[2][0]="aoshrbw";
		objarr[2][1]="321";
		objarr[2][2]="2436";
		
		return objarr;
		
	}

}
