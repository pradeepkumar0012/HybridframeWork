package com.crm.generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.objectRepository.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Baseclass {

	public WebDriver driver;
	public static WebDriver sdriver ;
	@BeforeSuite

	public void BS() {
		System.out.println("database connection");
	}
	@BeforeTest
	public void BT() {
		System.out.println("parallesl execution");
	}
	@BeforeClass
	public void BC() throws Throwable {
		System.out.println("launching the browser"); 
		File_utility f= new File_utility();
		String BROWSER = f.getpropertyKeyValue("browser");

		if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();

		} else if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		} 
		else {
			driver= new FirefoxDriver();
		}
		//sdriver=driver;


	}
	@BeforeMethod(groups = {"smoketest","Regressiontest"})
	public void BM() throws Throwable {
		System.out.println("login to application");
		File_utility f= new File_utility();
		String URL = f.getpropertyKeyValue("url");
		String username  =f.getpropertyKeyValue("un");
		String password=f.getpropertyKeyValue("pwd");
		driver.get(URL);
		Loginpage l = new Loginpage(driver);
		l.login(username, password);
	}


	@AfterMethod(groups = {"smoketest","Regressiontest"})
	public void AM() {
		System.out.println("logout from application");
	}

	@AfterClass(groups = {"smoketest","Regressiontest"})
	public void AC() {
		System.out.println("close the browser");
	}
	@AfterTest(groups = {"smoketest","Regressiontest"})
	public void AT() {
		System.out.println("executed succesfully");

	}
	@AfterSuite(groups = {"smoketest","Regressiontest"})
	public void AS() {
		System.out.println("database closed");
	}
}
