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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.generic_utility.Webdriver_utility;

public class Makemytrip1 {
	public static void main(String[] args) throws Throwable {
		System.setProperty("Webdriver.gecko.driver", "./geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FileInputStream fis= new FileInputStream("./makemytrip.txt");
		Properties pro =new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		driver.get(URL);
		FileInputStream fis1= new FileInputStream("./makemytripexcel.xlsx");
		Workbook book= WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("sheet1");
		Row ro = sheet.getRow(0);
		Cell cell= ro.getCell(0);
		String from = cell.getStringCellValue();
		System.out.println(from);
		driver.findElement(By.xpath("//span[@class='chNavText darkGreyText' and text()='Hotels']")).click();
		driver.findElement(By.xpath("//span[text()='City, Property name or Location']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']")).sendKeys(from);
		driver.findElement(By.xpath("//p[text()='Hyderabad, Telangana, India']")).click();
		String dt = "1";
		String checkin = "October";
		driver.findElement(By.xpath("//div[text()='"+checkin+"']/ancestor::div[@class='DayPicker-Month']/descendant::div[@class='DayPicker-Day' and text()='"+dt+"']")).click();
		String checkout = "October";
		String dt1 = "13";
		driver.findElement(By.xpath("//div[text()='"+checkout+"']/ancestor::div[@class='DayPicker-Month']/descendant::div[@class='DayPicker-Day' and text()='"+dt1+"']")).click();
		String adultno = "2";
		driver.findElement(By.xpath("//ul[@data-cy='adultCount']//li[text()='"+adultno+"']")).click();
		String childno = "2";
		driver.findElement(By.xpath("//p[@data-cy='childrenRange']/following::li[text()='"+childno+"']")).click();
		WebElement ele = driver.findElement(By.xpath("//select[@id='0']"));
		Webdriver_utility w= new Webdriver_utility();
		w.Selectbyindex(ele, 2);
		WebElement ele1 = driver.findElement(By.xpath("//select[@id='1']"));
		w.Selectbyindex(ele1, 5);
		
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
	}

}
