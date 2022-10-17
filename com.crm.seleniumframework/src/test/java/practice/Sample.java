package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Sample {
	public static void main(String[] args) throws Throwable {
		System.setProperty("Webdriver.gecko.driver", "./geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		FileInputStream fis= new FileInputStream("./commomdata.property.txt");
		Properties pro =new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String username=pro.getProperty("un");
		String password=pro.getProperty("pwd");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		FileInputStream fis1= new FileInputStream("./Book1.xlsx");
		Workbook book= WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String value =cell.getStringCellValue();
		System.out.println(value);

		driver.findElement(By.name("accountname")).sendKeys(value);
		driver.findElement(By.name("button")).click();
		String verify = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(verify.contains(value)) {
			System.out.println("tc is pass");
		}else {
			System.out.println("tc is fail");
		}



		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		

	}
}

